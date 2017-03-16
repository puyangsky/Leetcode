package com.puyangsky;

import java.util.Stack;

/**
 * Author: puyangsky
 * Date: 17/3/15
 * Complexity:
 * Method:
 */
public class L67 {
    public static String addBinary(String a, String b) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        int i=0;
        while(i<a.length())
            s1.push(a.charAt(i++));
        i = 0;
        while(i<b.length())
            s2.push(b.charAt(i++));

        char carry = '0';
        StringBuilder sb = new StringBuilder();
        while(!s1.empty() && !s2.empty()) {
            if(s1.peek() == '0' && s2.peek() == '0') {
                sb.append(carry);
                carry = '0';
            }
            if(s1.peek() == '1' && s2.peek() == '0' || s1.peek() == '0' && s2.peek() == '1') {
                if(carry == '0')
                    sb.append('1');
                else
                    sb.append('0');
            }

            if(s1.peek() == '1' && s2.peek() == '1') {
                if(carry == '1') {
                    sb.append('1');
                }else{
                    sb.append('0');
                }
                carry = '1';
            }
            s1.pop();s2.pop();
        }

        while (!s1.empty()) {
            if (s1.peek() == '0') {
                sb.append(carry);
                carry = '0';
            }else {
                if(carry == '1') {
                    sb.append('0');
                }else {
                    sb.append('1');
                }
            }
            s1.pop();
        }

        while (!s2.empty()) {
            if (s2.peek() == '0') {
                sb.append(carry);
                carry = '0';
            }else {
                if(carry == '1') {
                    sb.append('0');
                }else {
                    sb.append('1');
                }
            }
            s2.pop();
        }

        if(carry == '1')
            sb.append('1');

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "101111";
        String b = "10";

        System.out.println(addBinary(a,b));
    }
}
