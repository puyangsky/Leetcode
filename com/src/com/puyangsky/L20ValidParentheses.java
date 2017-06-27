package com.puyangsky;

import java.util.Stack;

/**
 * Author:      puyangsky
 * Date:        17/6/27 下午2:33
 * Method:      Stack
 * Difficulty:  Easy
 */
public class L20ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        Stack<String> a = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i, i+1);
            switch (ss) {
                case "[":
                    a.push(ss);
                    break;
                case "{":
                    a.push(ss);
                    break;
                case "(":
                    a.push(ss);
                    break;
                case "]":
                    if (a.empty() || !a.peek().equals("[")) return false;
                    else a.pop();
                    break;
                case "}":
                    if (a.empty() || !a.peek().equals("{")) return false;
                    else a.pop();
                    break;
                case ")":
                    if (a.empty() || !a.peek().equals("(")) return false;
                    else a.pop();
                    break;
            }
        }
        return a.empty();
    }

    public static void main(String[] args) {
        String s = "([)]{}";
        System.out.println(isValid(s));
    }
}
