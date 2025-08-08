import java.util.Scanner;
import java.util.Stack;

/**
 * Parenthesis Balance Checker
 * This program checks if a sequence of parentheses is balanced.
 */
public class Main {
  /**
   * Main method to read input and check for balanced parentheses.

   * @param args command line arguments (not used)
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine(); // Read the first line which is not used

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().trim();
      if (line.isEmpty()) {
        System.out.println("Yes");
      } else if (line.length() % 2 != 0) {
        System.out.println("No");
      } else {
        System.out.println(isBalanced(line));
      }
    }
    scanner.close();
  }
  
  /**
   * Checks if the sequence of parentheses is balanced.

   * @param line represents a sequence of parentheses
   * @return "YES" if balanced, "NO" if not
   */
  public static String isBalanced(String line) {
    Stack<Character> stack = new Stack<>();

    for (char ch : line.toCharArray()) {
      if (ch == '(' || ch == '[') {
        stack.push(ch);
      } else if (stack.isEmpty()) {
        return "No";
      } else if (ch == ')') {
        char top = stack.pop();
        if (top != '(') {
          return "No";
        }
      } else if (ch == ']') {
        char top = stack.pop();
        if (top != '[') {
          return "No";
        }
      }
    }
    return stack.isEmpty() ? "Yes" : "No";
  }
}
