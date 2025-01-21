### Install sqlite3
```console
  sudo apt update
  sudo apt install sqlite3
  sqlite3 -version
```

### Download data and schema
```console
  curl -O https://courses.edx.org/asset-v1:StanfordOnline+SOE.YDB-SQL0001+2T2020+type@asset+block/rating.sql
```

### Create DB
```console
  sqlite3 movieinfo.db < rating.sql
```

### Questions
Q1. Find the titles of all movies directed by Steven Spielberg.<br>
Q2. Find all years that have a movie that received a rating of 4 or 5, and sort them in increasing order.<br>
Q3. Find the titles of all movies that have no ratings.<br>
Q4. Some reviewers didn't provide a date with their rating. Find the names of all reviewers who have ratings with a NULL value for the date.<br>
Q5. Write a query to return the ratings data in a more readable format: reviewer name, movie title, stars, and ratingDate. Also, sort the data, first by reviewer name, then by movie title, and lastly by number of stars.<br>
Q6. For all cases where the same reviewer rated the same movie twice and gave it a higher rating the second time, return the reviewer's name and the title of the movie.<br>
Q7. For each movie that has at least one rating, find the highest number of stars that movie received. Return the movie title and number of stars. Sort by movie title.<br>
Q8. For each movie, return the title and the 'rating spread', that is, the difference between highest and lowest ratings given to that movie. Sort by rating spread from highest to lowest, then by movie title.<br>
Q9. Find the difference between the average rating of movies released before 1980 and the average rating of movies released after 1980. (Make sure to calculate the average rating for each movie, then the average of those averages for movies before 1980 and movies after. Don't just calculate the overall average rating before and after 1980.)<br>
Q10. Find the names of all reviewers who rated Gone with the Wind.<br>
Q11. For any rating where the reviewer is the same as the director of the movie, return the reviewer name, movie title, and number of stars.<br>
Q12. Return all reviewer names and movie names together in a single list, alphabetized. (Sorting by the first name of the reviewer and first word in the title is fine; no need for special processing on last names or removing "The".)<br>
Q13. Find the titles of all movies not reviewed by Chris Jackson.<br>
Q14. For all pairs of reviewers such that both reviewers gave a rating to the same movie, return the names of both reviewers. Eliminate duplicates, don't pair reviewers with themselves, and include each pair only once. For each pair, return the names in the pair in alphabetical order.<br>
Q15. For each rating that is the lowest (fewest stars) currently in the database, return the reviewer name, movie title, and number of stars.<br>
Q16. List movie titles and average ratings, from highest-rated to lowest-rated. If two or more movies have the same average rating, list them in alphabetical order.<br>
Q17. Find the names of all reviewers who have contributed three or more ratings.<br>
Q18. Some directors directed more than one movie. For all such directors, return the titles of all movies directed by them, along with the director name. Sort by director name, then movie title.<br> 
Q19. Find the movie(s) with the highest average rating. Return the movie title(s) and average rating.<br>
Q20. For each director, return the director's name together with the title(s) of the movie(s) they directed that received the highest rating among all of their movies, and the value of that rating. Ignore movies whose director is NULL.<br>
