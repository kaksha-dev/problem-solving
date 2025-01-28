
### Solutiions
#### Q1. Find the titles of all movies directed by Steven Spielberg.
```console
  SELECT title FROM Movie WHERE director = "Steven Spielberg";
```

#### Q2. Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.
```console
  SELECT DISTINCT M.year
  FROM Movie M INNER JOIN Rating R ON M.mID = R.mID
  WHERE R.stars >= 4
  ORDER BY year;
```

#### Q3. Find the titles of all movies that have no ratings.
```console
  SELECT title
  FROM Movie M 
  WHERE M.mID NOT IN (SELECT DISTINCT mID FROM Rating);
```

#### Q4. Some reviewers didn't provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date.
```console
  SELECT DISTINCT RE.name
  FROM Reviewer RE INNER JOIN (SELECT * FROM RATING WHERE ratingDate IS NULL) RA
  ON RE.rID = RA.rID;
```

#### Q5. Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars.
```console
  SELECT RE.name AS reviewer_name, M.title AS title, RA.stars AS stars, RA.ratingDate as ratingDate
  FROM Rating AS RA
  INNER JOIN Movie AS M ON M.mID = RA.mID
  INNER JOIN Reviewer AS RE ON RE.rID = RA.rID
  ORDER BY reviewer_name, title, stars;
```

#### Q6. For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time, return the reviewer's name and the title of the movie.
```console
  SELECT DISTINCT RE.name, M.title
  FROM Rating R1
  INNER JOIN Rating R2
    ON R1.rId = R2.rID
    AND R1.mId = R2.mId 
    AND R2.ratingDate > R1.ratingDate
    AND R2.stars > R1.stars
  INNER JOIN Movie M
    ON M.mID = R1.mID
  INNER JOIN Reviewer RE
    ON R1.rID = RE.rID;
```

#### Q7. For each movie that has at least one rating, find the highest number of stars that movie received. Return the movie title and number of stars. Sort by movie title.
```console
  SELECT M.title AS title, Max(R.stars) AS max_rating
  FROM Rating AS R
  INNER JOIN Movie AS M
    ON M.mID = R.mID
  GROUP BY(title);
```

#### Q8. For each movie, return the title and the 'rating spread', that is, the difference between highest and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.
```console
  SELECT M.title AS title, Max(R.stars)-Min(R.stars) AS rating_spread
  FROM Rating AS R
  INNER JOIN Movie AS M ON M.mID = R.mID
  GROUP BY title
  ORDER BY rating_spread DESC, title;
```

#### Q9. Find the difference between the average rating of movies released before 1980 and the average rating of movies released after 1980. (Make sure to calculate the average rating for each movie, then the average of those averages for movies before 1980 and movies after. Don't just calculate the overall average rating before and after 1980.)
```console
  SELECT AVG(Before1980.avg) - AVG(After1980.avg)
  FROM (
    SELECT AVG(stars) AS avg
    FROM Movie
    INNER JOIN Rating USING(mId)
    WHERE year < 1980
    GROUP BY mId
  ) AS Before1980, (
    SELECT AVG(stars) AS avg
    FROM Movie
    INNER JOIN Rating USING(mId)
    WHERE year > 1980
    GROUP BY mId
  ) AS After1980;  
```

#### Q10. Find the names of all reviewers who rated Gone with the Wind.
```console
  SELECT DISTINCT name
  FROM Reviewer AS Re
  INNER JOIN Rating AS Ra
    ON Re.rId = Ra.rId
  INNER JOIN Movie as M
    ON Ra.mId = M.mId
  WHERE M.title = "Gone with the Wind";
```

#### Q11. For any rating where the reviewer is the same as the director of the movie, return the reviewer name, movie title, and number of stars.
```console
  SELECT Re.name, M.title, RA.stars
  FROM Reviewer AS Re
  INNER JOIN Rating AS Ra
    ON Re.rId = Ra.rId
  INNER JOIN Movie as M
    ON Ra.mId = M.mId
  WHERE Re.name = M.director;
```

#### Q12. Return all reviewer names and movie names together in a single list, alphabetized. (Sorting by the first name of the reviewer and first word in the title is fine; no need for special processing on last names or removing "The".)
```console
  SELECT DISTINCT Re.name
  FROM Reviewer AS Re
  UNION
  SELECT DISTINCT M.title
  FROM Movie As M
  ORDER BY Re.name, M.title;
```

#### Q13. Find the titles of all movies not reviewed by Chris Jackson.
```console
  SELECT M.title
  FROM Movie AS M 
  WHERE M.mId NOT IN
    (
      SELECT mId FROM Rating AS RA
       WHERE RA.rID IN
       (
         SELECT rID 
         FROM Reviewer as Re
         WHERE Re.name = "Chris Jackson"
       )
    );
```

#### Q14. For all pairs of reviewers such that both reviewers gave a rating to the same movie, return the names of both reviewers. Eliminate duplicates, don't pair reviewers with themselves, and include each pair only once. For each pair, return the names in the pair in alphabetical order.
```console
  SELECT DISTINCT ReInfo1.name, ReInfo2.name
  FROM
  (
    SELECT DISTINCT RA1.rID AS rID, name, mID
    FROM Rating AS RA1
    INNER JOIN Reviewer AS RE1
      ON RA1.rID = RE1.rID
  ) AS ReInfo1,
  (
    SELECT DISTINCT RA2.rID AS rID, name, mID
    FROM Rating AS RA2
    INNER JOIN Reviewer AS RE2
      ON RA2.rID = RE2.rID
  ) AS ReInfo2
  WHERE ReInfo1.name < ReInfo2.name 
    AND  ReInfo1.mID = ReInfo2.mID
  ORDER BY ReInfo1.name, ReInfo2.name;
```

#### Q15. For each rating that is the lowest (fewest stars) currently in the database, return the reviewer name, movie title, and number of stars.
```console
  SELECT Re.name, M.title, Ra.stars
  FROM Reviewer AS Re
  INNER JOIN Rating AS Ra
    ON Re.rId = Ra.rId
  INNER JOIN Movie as M
    ON Ra.mId = M.mId
  WHERE stars IN (SELECT MIN(stars) from Rating);
```

#### Q16. List movie titles and average ratings, from highest-rated to lowest-rated. If two or more movies have the same average rating, list them in alphabetical order.
```console
  SELECT M.title, AVG(stars)
  FROM Rating AS RA
  INNER JOIN Movie AS M
    ON RA.mId = M.mId
  GROUP BY M.title
  ORDER BY AVG(stars) DESC, M.title;
```

#### Q17. Find the names of all reviewers who have contributed three or more ratings.
```console
  SELECT RE.name
  FROM Rating AS RA
  INNER JOIN Reviewer AS RE
    ON RA.rID = RE.rID
  GROUP BY RA.rID
  HAVING COUNT(*) >= 3;
```

#### Q18. Some directors directed more than one movie. For all such directors, return the titles of all movies directed by them, along with the director name. Sort by director name, then movie title. 
```console
  SELECT title, director
  FROM Movie AS M1
  WHERE M1.director IN
  (
	  SELECT director
	  FROM Movie
	  GROUP BY director
	  HAVING COUNT(mID) > 1
  )
  ORDER BY director, title;
```

#### Q19. Find the movie(s) with the highest average rating. Return the movie title(s) and average rating.
```console
  SELECT M.title, AVG(RA.stars)
  FROM Rating AS RA
  INNER JOIN Movie AS M
    ON RA.mId = M.mID
  GROUP BY M.mID
  Having AVG(stars) =
    (
      SELECT MAX(cStars) FROM 
      (
        SELECT mID, AVG(stars) AS cStars
        FROM Rating
        GROUP BY mID
      )
    )
```

#### Q20. For each director, return the director's name together with the title(s) of the movie(s) they directed that received the highest rating among all of their movies, and the value of that rating. Ignore movies whose director is NULL.
```console
  SELECT DISTINCT M.director, M.title, DInfo.stars
  FROM Movie as M
  INNER JOIN Rating AS RA
    ON M.mID = RA.mID
  INNER JOIN 
    (
      SELECT M.director, MAX(Stars) AS stars
      FROM Rating AS RA
      INNER JOIN Movie as M
        ON RA.mId = M.MId
       GROUP BY director
    ) AS DInfo
  ON DInfo.director = M.director
    AND RA.stars = DInfo.stars;
```
