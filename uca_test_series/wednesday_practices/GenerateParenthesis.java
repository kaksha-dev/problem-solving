import java.util.*;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = (ArrayList<String>[]) new ArrayList[n + 1];
        dp[0] = new ArrayList<String>();
        dp[0].add("");
        dp[1] = new ArrayList<String>();
        dp[1].add("()");
        for (int i = 2; i <= n; i++) {
            dp[i] = new ArrayList<String>();
            for (int j = 0; j < i; j++) {
                for (String s1 : dp[j]) {
                    for (String s2 : dp[i - 1 - j]) {
                        dp[i].add("(" + s1 + ")" + s2);
                    }
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(GenerateParenthesis.generateParenthesis(3));
    }

}