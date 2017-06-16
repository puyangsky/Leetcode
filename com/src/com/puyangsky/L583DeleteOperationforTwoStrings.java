package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/6/16
 * Method:
 */
public class L583DeleteOperationforTwoStrings {

    /**
     * 最长公共子串
     * @param s source string
     * @param t target string
     * @return 最长公共子串的长度
     */
    public static int lcs(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return 0;

        int len1 = s.length(), len2 = t.length();

        int[][] dp = new int[len1+1][len2+1];

        for (int i = 0; i <= len1; i++)
            for (int j = 0; j <= len2; j++)
                dp[i][j] = 0;

        int max = 0;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        return max;

    }

    public static int minDistance(String word1, String word2) {
        int common = lcs(word1, word2);
        return word2.length() + word1.length() - 2 * common;
    }

    public static void main(String[] args) {
        System.out.println(lcs("abcd", "acbcdwea"));
    }
}
