package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/4/27
 */
public class L43MultiplyStrings {
    public String addString(String num1, String num2) {
        int carry = 0, i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < num1.length() && j < num2.length()) {
            int res = num1.charAt(i) + num2.charAt(j) - '0' - '0' + carry;
            if (res > 10) {
                carry = 1;
                res %= 10;
            }else {
                carry = 0;
            }
            i++;j++;
            sb.append(res);
        }

        while (i < num1.length()) {
            int res = num1.charAt(i) - '0' + carry;
            if (res > 10) {
                carry = 1;
                res %= 10;
            }else {
                carry = 0;
            }
            i++;
            sb.append(res);
        }

        while (j < num2.length()) {
            int res = num2.charAt(j) - '0' + carry;
            if (res > 10) {
                carry = 1;
                res %= 10;
            }else {
                carry = 0;
            }
            j++;
            sb.append(res);
        }

        return sb.toString();
    }
    public String multiply(String num1, String num2) {
        return "";
    }
}
