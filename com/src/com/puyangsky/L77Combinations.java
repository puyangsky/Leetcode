package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:      puyangsky
 * Date:        17/6/22 上午11:04
 * Method:      递归回溯
 * Difficulty:  Medium
 */
public class L77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), 1, k, n);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> cur, int index, int k, int n) {
        if (cur.size() == k) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i=index;i<=n;i++) {
            cur.add(i);
            dfs(ans, cur, i+1, k, n);
            cur.remove(cur.size()-1);
        }
    }
}
