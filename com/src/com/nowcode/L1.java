package com.nowcode;

import java.util.Scanner;

/**
 * Author: puyangsky
 * Date: 17/3/25
 * Complexity:
 * Method:
 */
public class L1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tX = new int[n];
        int[] tY = new int[n];
        for(int i = 0; i < n; i++){
            tX[i] = sc.nextInt();
        }

        for (int i=0;i<n;i++) {
            tY[i] = sc.nextInt();
        }

        int gx, gy;
        gx = sc.nextInt();
        gy = sc.nextInt();

        int walkTime = sc.nextInt();
        int taxiTime = sc.nextInt();

        int min = Integer.MAX_VALUE;

        int walk = (Math.abs(gx) + Math.abs(gy)) * walkTime;
        if(min > walk)
            min = walk;

        for(int i=0;i<n;i++) {
            int taxi = (Math.abs(tX[i]) + Math.abs(tY[i])) * walkTime +
                    (Math.abs(gx - tX[i]) + Math.abs(gy - tY[i])) * taxiTime;

            if(min > taxi) min = taxi;
        }
        System.out.println(min);
    }
}
