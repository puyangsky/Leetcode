package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/4/27
 */
public class L557ReverseWordsinaStringIII {
    public static String reverseWords(String s) {
        s = s.trim();
        if (s.length() == 0) return s;

        int i = 0, j = 0;

        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) != ' ') i++;
            for (int k = i-1;k>=j;k--) {
                sb.append(s.charAt(k));
            }
            if (i == s.length()) break;
            sb.append(' ');
            while (i < s.length() && s.charAt(i) == ' ') i++;
            j = i;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
