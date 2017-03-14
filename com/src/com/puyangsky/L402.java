package com.puyangsky;

import java.io.ObjectInputStream;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by puyangsky on 17/3/5.
 * 题意：去掉K个0，使得数字最小
 * 思路：利用栈把当前数字压栈，下标后移，将栈顶数字与当前下标指向的数字进行大小比较，如果栈顶数字较大则pop掉，k--；
 * 最终如果k>0，则pop k 次栈
 * 将栈中数字reverse，去除首位的0
 */
public class L402 {
    private static final String ZERO = "0";

    public static String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";

        Stack<Character> stack = new Stack<Character>();
        int i=0;
        stack.push(num.charAt(i++));
        while (i<num.length()) {
            while (k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i++));
        }

        while (!stack.empty() && k-->0) {
            stack.pop();
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.empty()) {
            sb.append(stack.peek());
            stack.pop();
        }

        sb.reverse();

        i=0;
        while (i<sb.length()) {
            if (sb.charAt(i) == '0')
                sb.deleteCharAt(i);
            else
                break;
        }
        if(sb.length() == 0)
            sb.append('0');
        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "1234567890";
        System.out.println(removeKdigits(num, 1));

    }
}
