package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/29 上午12:07
 * Method:
 * Difficulty:
 */
public class L204CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i=2;i<n;i++) {
            isPrime[i] = true;
        }
        for (int i = 2;i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) ans++;
        }

        return ans;
    }
}
