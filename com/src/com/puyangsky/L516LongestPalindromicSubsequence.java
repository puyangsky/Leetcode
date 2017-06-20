package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/6/20
 * Method: DP
 */
public class L516LongestPalindromicSubsequence {
    public static int longestPalindromeSubseq(String s) {
        if (s==null || "".equals(s)) return 0;
        int[][] dp = new int[s.length()][s.length()];

        for (int i=s.length()-1;i>=0;i--) {
            dp[i][i] = 1;
            for (int j=i+1;j<s.length();j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("abcadcba"));
    }
}
