package com.puyangsky;

import java.util.*;

/**
 * Author:      puyangsky
 * Date:        17/6/21 下午9:16
 * Method:      DFS
 * Difficulty:  Medium
 */
public class L40CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> tmp = new ArrayList<>();
        dfs(tmp, new ArrayList<Integer>(), candidates, target, 0);

        return tmp;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int target, int index) {

        if (target == 0) {
            List<Integer> list = new ArrayList<>(cur);
            ans.add(list);
            return;
        }

        if (target < 0) return;

        for (int i=index; i < candidates.length; i++) {
            // 跳过相同的字符
            if (i > index && candidates[i-1] == candidates[i]) continue;
            cur.add(candidates[i]);
            dfs(ans, cur, candidates, target - candidates[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
