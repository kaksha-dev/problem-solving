import java.util.Stack;

/**
 * This class provides a method to find the length of the longest valid
 * parentheses substring. It uses a stack to keep track of indices of
 * unmatched '(' characters and calculates lengths of valid parentheses
 * sequences as it processes the string.
 */
public class LongestValidParenthesis {
  /**
   * This method calculates the length of the longest valid parentheses
   * substring in the given string.

    * @param s The input string containing parentheses.
    * @return The length of the longest valid parentheses substring.
    */
  public int longestValidParentheses(String s) {
    int maxLength = 0;
    Stack<Integer> stack = new Stack<>();
    int[] lenAtCurrentIndex = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
        lenAtCurrentIndex[i] = 0; // Initialize length for '('
      } else {
        if (stack.isEmpty()) {
          lenAtCurrentIndex[i] = 0;
        } else {
          int start = stack.pop();
          lenAtCurrentIndex[i] = i - start + 1;
          if (start > 0) {
            // Add length of valid sequence before the current one
            lenAtCurrentIndex[i] += lenAtCurrentIndex[start - 1];
          }
          maxLength = Math.max(maxLength, lenAtCurrentIndex[i]);
        }
      }
    }
    return maxLength;
  }

  /**
   * Main method to test the longestValidParentheses function.
   * It runs several test cases to ensure the function works correctly.

    * @param args - Command line arguments (not used).
    */
  public static void main(String[] args) {
    LongestValidParenthesis lvp = new LongestValidParenthesis();
    String s = "(()())";
    assert lvp.longestValidParentheses(s) == 6 : "Test failed for: " + s;
    s = "(()";
    assert lvp.longestValidParentheses(s) == 2 : "Test failed for: " + s;
    s = ")()())";
    assert lvp.longestValidParentheses(s) == 4 : "Test failed for: " + s;
    s = "";
    assert lvp.longestValidParentheses(s) == 0 : "Test failed for: " + s;
    s = "()(())";
    assert lvp.longestValidParentheses(s) == 6 : "Test failed for: " + s;
    System.out.println("All tests passed!");
  } 
}