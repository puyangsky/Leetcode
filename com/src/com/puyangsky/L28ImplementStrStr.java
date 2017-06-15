package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/5/23
 * Method:
 */
public class L28ImplementStrStr {

    public static int strStr(String haystack, String needle) {
        int p = 0, q = 0, l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        if (l2 == 0) return 0;
        while (p < l1 && haystack.charAt(p) != needle.charAt(q))
            p++;
        if (p == l1) return -1;

        while (p < l1) {
            while (p < l1 && haystack.charAt(p) != needle.charAt(q))
                p++;
            while (p < l1 && q < l2 && haystack.charAt(p) == needle.charAt(q)) {
                p++;q++;
            }
            if (q == l2) return p-q;
            else {
                p = p - q + 1;
                q = 0;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issipi"));
    }
}
