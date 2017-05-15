package com.nowcode;

import java.util.Scanner;

/**
 * Author: puyangsky
 * Date: 17/3/25
 * Complexity:
 * Method:
 */
public class L2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        if(s.length() == 0)
            System.out.println(0);

        int len = s.length();

        int B = 0, G = 0;
        for(int i = 0;i<len;i++) {
            if(s.charAt(i) == 'B')
                B++;
            else if (s.charAt(i) == 'G')
                G++;
        }

        //记录下每个B出现的下标
        int[] index = new int[B];
        int p = 0;
        for(int i = 0;i<len;i++) {
            if (s.charAt(i) == 'B')
                index[p++] = i;
        }
        int common = B * (B-1) / 2;

        int min1 = 0, min2 = 0;
        for (int i = 0;i<B;i++) {
            min1 += index[i];
            min2 += len - 1 - index[i];
        }

        int min = Math.min(min1, min2);

        System.out.println(min - common);
    }
}
