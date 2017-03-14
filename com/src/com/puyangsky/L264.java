package com.puyangsky;

/**
 * Created by puyangsky on 17/3/9.
 */
public class L264 {

    public static int min(int a, int b, int c) {
        int t = a < b ? a : b;
        return t < c ? t : c;
    }

    public static int nthUglyNumber(int n) {
        if(n <= 0) return -1;
        int[] u = new int[n];

        u[0] = 1;

        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        int cur = 1;

        int maxIndex = 0;

        while(cur < n) {
            int m = min(u[index2] * 2, u[index3] * 3, u[index5] * 5);
            u[cur++] = m;
            maxIndex++;
            while (u[index2]*2 <= u[maxIndex]) index2++;
            while (u[index3]*3 <= u[maxIndex]) index3++;
            while (u[index5]*5 <= u[maxIndex]) index5++;

        }

        return u[n-1];
    }


    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
