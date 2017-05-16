package com.puyangsky;

import java.util.*;

/**
 * Author: puyangsky
 * Date:   17/5/15
 * Method: 递归回溯
 */
public class L39CombinationSum {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int[] candidates, int target, Stack<Integer> path, int start) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=start;i < candidates.length; ++i) {
            path.push(candidates[i]);
            dfs(candidates, target - candidates[i], path, i);
            path.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return ans;
        Stack<Integer> path = new Stack<>();
        dfs(candidates, target, path, 0);
        return ans;
    }
}
