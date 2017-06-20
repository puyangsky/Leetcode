package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/20 下午4:35
 * Method:      DP
 * Difficulty:
 */
public class L5LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        String res = "";

        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i=0;i<s.length();i++) {
            dp[i][i] = true;
            for (int j=i+1;j<s.length();j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && res.length() < (j-i+1))
                    res = s.substring(i, j+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("abc".substring(0,2));
        System.out.println("abc".substring(1,3));
        System.out.println(longestPalindrome("ccc"));
    }
}
