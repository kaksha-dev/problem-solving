public class GenerateParenthesis {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * 
     * Constraints:
     * 1. 1 <= n <= 8
     * 2. The solution set must not contain duplicate combinations.
     * 
     * Example:
     * Input: n = 3
     * Output: ["((()))","(()())","(())()","()(())","()()()"]
     * 
     * @param n - Number of pairs of parentheses.
     * @returns List<String> - A list of all combinations of well-formed parentheses.
     */
    public List<String> generateParenthesis(int n) {
        return new ArrayList<>();
    }

    /**
     * Main method for testing the GenerateParenthesis class.
     */
    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        int n = 3;
        List<String> result = gp.generateParenthesis(n);
        List<String> expected = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        
        assert result.size() == expected.size() && result.containsAll(expected) : "Test case failed";
    }
}