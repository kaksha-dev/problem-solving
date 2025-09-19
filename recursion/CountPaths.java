/**
 * Given a grid of size m x n, you are initially positioned at (x, y) and
 * you want to reach (0, 0). You can only move either up, down, left or 
 * right at any point in time.
 * 
 * Determine the number of possible unique paths from (x, y) to (0, 0).
 * 
 * Constraints:
 * 1. You cannot move outside the grid.
 * 2. You do not want to take unnecessary steps, so you will only move 
 *    in directions that bring you closer to (0, 0).
 * 3. 0 <= x < m
 * 4. 0 <= y < n
 * 5. 1 <= m, n <= 100
 * 
 * Example:
 * Input: m = 3, n = 3, x = 2, y = 2
 * Output: 6
 * Explanation: The possible unique paths are:
 * 1. (2,2) -> (1,2) -> (0,2) -> (0,1) -> (0,0)
 * 2. (2,2) -> (1,2) -> (1,1) -> (0,1) -> (0,0)
 * 3. (2,2) -> (1,2) -> (1,1) -> (1,0) -> (0,0)
 * 4. (2,2) -> (2,1) -> (1,1) -> (0,1) -> (0,0)
 * 5. (2,2) -> (2,1) -> (1,1) -> (1,0) -> (0,0)
 * 6. (2,2) -> (2,1) -> (2,0) -> (1,0) -> (0,0)
 */

 public class CountPaths {
  /**
   * Count the number of unique paths from (x, y) to (0, 0) in an m x n grid.
   * 
   * @param m - Number of rows in the grid.
   * @param n - Number of columns in the grid.
   * @param x - Starting row position.
   * @param y - Starting column position.
   * @returns int - Number of unique paths from (x, y) to (0, 0).
   */
  public int countPaths(int m, int n, int x, int y) {
    return 0;
  }

  /**
   * Main method for testing the CountPaths class.
   */
  public static void main(String[] args) {
    CountPaths cp = new CountPaths();
    
    assert cp.countPaths(3, 3, 2, 2) == 6 : "Test case 1 failed";
    assert cp.countPaths(3, 3, 1, 1) == 2 : "Test case 2 failed";
    assert cp.countPaths(3, 3, 0, 0) == 0 : "Test case 3 failed";

  }
 }
