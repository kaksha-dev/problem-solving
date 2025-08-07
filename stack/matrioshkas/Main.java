import java.util.Scanner;
import java.util.Stack;

/**
 * Matrioshka Doll Checker
 * This program valdates a sequence of integers representing matrioshka dolls.
 * A doll can contains multiple smaller dolls, and sum of sizes of all inner
 * dolls must be strictly less than the size of the outer doll.
 */
public class Main {
  static class Doll {
    private int size;
    private int childSize;

    public Doll(int size, int childSize) {
      this.size = size;
      this.childSize = childSize;
    }

    public int getSize() {
      return size;
    }

    public int getChildSize() {
      return childSize;
    }

    public void incrementChildSize(int value) {
      this.childSize += value;
    }
  }

  /**
   * Main method to read input and check for valid matrioshka dolls.

   * @param args command line arguments (not used)
   *     Reads lines of integers until EOF, checking each line for validity.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (line.trim().isEmpty()) {
        System.out.println(":-) Matrioshka!");
        continue;
      }
      System.out.println(isMatrioshka(line));
    }
    scanner.close();
  }

  /**
   * Checks if the sequence of integers represents a valid matrioshka doll
   * structure.

   * @param line represents a plausible sequence of matrioshka doll sizes
   * @return a string indicating whether the sequence is valid or not
   *         ":-) Matrioshka!" if valid, ":-( Try again." if invalid
   */
  public static String isMatrioshka(String line) {
    String[] parts = line.split("\\s+");
    Stack<Doll> stack = new Stack<>();

    for (String part : parts) {
      int size = Integer.parseInt(part);

      if (stack.isEmpty() && size < 0) {
        stack.push(new Doll(-size, 0));
      } else if (stack.isEmpty() && size > 0) {
        return ":-( Try again.";
      } else if (size > 0 && size == stack.peek().getSize()) {
        stack.pop();
        continue;
      } else if (size > 0) {
        return ":-( Try again.";
      } else if (size < 0) {
        Doll doll = stack.peek();

        doll.incrementChildSize(-size);
        if (doll.getChildSize() >= doll.getSize()) {
          return ":-( Try again.";
        }
        stack.push(new Doll(-size, 0));
      }
    }
    if (!stack.isEmpty()) {
      return ":-( Try again.";
    }
    return ":-) Matrioshka!";
  }
}