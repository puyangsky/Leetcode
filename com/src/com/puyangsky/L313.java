package com.puyangsky;

/**
 * Created by puyangsky on 17/3/9.
 */
public class L313 {

//    public static boolean isSuperUglyNumber(int k, int[] primes) {
//        boolean flag = false;
//        for (int prime : primes) {
//            while(k % prime == 0)
//                k /= prime;
//            if (k == 1) {
//                flag = true;
//                break;
//            }
//        }
//
//        return flag;
//    }
//
//    public static int nthSuperUglyNumber(int n, int[] primes) {
//        if (n <= 0 || primes.length == 0) return -1;
//        if (n == 1) return 1;
//        int count = 1;
//        int i = 1;
//        int maxUglyNumber = 1;
//        while (count <= n) {
//            if (isSuperUglyNumber(i, primes)) {
//                maxUglyNumber = i;
//                count++;
//            }
//            i++;
//        }
//        return maxUglyNumber;
//    }

    public static int min(int[] temp) {
        int m = Integer.MAX_VALUE;
        for(int i : temp) {
            if (i < m)
                m = i;
        }
        return m;
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes.length == 0) return -1;
        if (n == 1) return 1;
        int len = primes.length;
        int[] idx = new int[len];
        int[] u = new int[n];

        u[0] = 1;

        int cur = 1;

        while (cur < n) {
            //求得最小的一个刚好大于当前最大的丑数的丑数，作为下一个丑数
            int[] temp = new int[len];
            for (int i=0;i<len;i++)
                temp[i] = u[idx[i]]*primes[i];

            int m = min(temp);
            u[cur] = m;

            for(int i=0;i<len;i++) {
                while (u[idx[i]]*primes[i] <= u[cur]) {
                    idx[i]++;
                }
            }

            cur++;
        }

        return u[n-1];
    }


    public static void main(String[] args) {
        int[] primes = {2,7,13,19};

        System.out.println(nthSuperUglyNumber(11, primes));
    }
}
