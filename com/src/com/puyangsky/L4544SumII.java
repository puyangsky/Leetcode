package com.puyangsky;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: puyangsky
 * Date:   17/6/18
 * Method:
 */
public class L4544SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for(int i : C) {
            for (int j : D) {
                ans += map.getOrDefault(-1*(i+j), 0);
            }
        }

        return ans;
    }
}
