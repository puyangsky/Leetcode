package com.nowcode;

import java.util.Scanner;

/**
 * Author: puyangsky
 * Date: 17/3/25
 * Complexity:
 * Method:
 */
public class L3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] num = new int[n];
        for(int i=0;i<n;i++) {
            num[i] = sc.nextInt();
        }

        for(int i=0;i<k;i++) {
            int temp = num[0];
            for(int j=0;j<n-1;j++) {
                num[j] += num[j+1];
                if(num[j] >= 100)
                    num[j] %= 100;
            }
            num[n-1] += temp;
            num[n-1] %= 100;
        }

        for(int i=0;i<n-1;i++)
            System.out.print(num[i] + " ");
        System.out.print(num[n-1]);
    }
}
