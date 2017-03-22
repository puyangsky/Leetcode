package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/3/22
 * Question: Reverse Words in a String
 * Complexity: Time O(N^2)
 * Method: 从后往前遍历，快慢指针，注意空格的处理
 */
public class L151 {
    public static String reverseWords(String s) {
        if(s == null || s.trim().length() == 0) return "";

        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int fast = s.length() - 1;
        int slow = fast;
        while (fast >= 0) {
            while (fast >= 0 && s.charAt(fast) != ' ') fast--;
            //注意fast为-1的情况，避免出现越界异常
            for(int i=fast+1;i<=slow;i++) sb.append(s.charAt(i));
            sb.append(' ');
            while (fast >= 0 && s.charAt(fast) == ' ') fast--;
            slow = fast;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  he is   a blue  sky    "));
    }
}
