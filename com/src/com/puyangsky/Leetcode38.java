package com.puyangsky;

/**
 * Created by Administrator on 2016/11/9.
 */
public class Leetcode38 {
    public static String countAndSay(int n) {
        String s = "1";
        if (n == 1) {
            return s;
        }
        String ss = resolve(countAndSay(n-1));
        return ss;
    }
    //s = "21"
    public static String resolve(String s) {
        String temp = "";
        int index = 0;
        char c = s.charAt(0);
        while(index < s.length()) {
            int count = 1;
            while(index++ < s.length() - 1) {
                if(c == s.charAt(index)) {
                    count++;
                    continue;
                }
                temp += (String.valueOf(count) + String.valueOf(c));
                count = 1;
                c = s.charAt(index);
            }
            temp += (String.valueOf(count) + String.valueOf(c));
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}