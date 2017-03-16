package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/3/16
 * Complexity: O(N) N为s和t的长度最大者
 * Method: 两个指针从前往后遍历一次即可
 */
public class L392 {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if(s.charAt(i) == t.charAt(j))
                i++;
            j++;
        }
        return i == s.length() && j <= t.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("av", "a"));
    }
}
