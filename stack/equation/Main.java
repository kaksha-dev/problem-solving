import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        scanner.nextLine(); // Skip the empty line after the number of test cases

        for (int t = 0; t < testCases; t++) {
            StringBuilder equation = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if(line.isEmpty()) {
                     while (!stack.isEmpty()) {
                        equation.append(stack.pop());
                    }
                    System.out.println(equation.toString());
                    if(t != testCases-1) System.out.println();
                    equation.setLength(0);
                    break; // End of current test case
                }
                
                if(line.chars().allMatch(Character::isDigit)) {
                    equation.append(line);
                }
                else if(line.equals("(")) {
                    stack.push('(');
                }
                else if(line.equals(")")) {
                    while(stack.peek() != '(') {
                        equation.append(stack.pop());
                    }
                    stack.pop(); // pop the '('
                }
                else if(line.equals("+") || line.equals("-")) {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        equation.append(stack.pop());
                    }
                    stack.push(line.charAt(0));
                }
                else {
                    if(stack.isEmpty() || stack.peek() == '(') {
                        stack.push(line.charAt(0));
                    } 
                    else if(stack.peek() == '+' || stack.peek() == '-') {
                        stack.push(line.charAt(0));
                    }
                    else {
                        if(!stack.isEmpty() && stack.peek() != '(') {
                            equation.append(stack.pop());
                        } 
                        stack.push(line.charAt(0));
                    }
                }
            }
            if(t == testCases - 1 && equation.length() > 0) {
                while (!stack.isEmpty()) {
                    equation.append(stack.pop());
                }
                System.out.println(equation.toString());
            }
        }
        scanner.close();
    }
}
