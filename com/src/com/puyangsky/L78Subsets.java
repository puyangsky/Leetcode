package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:      puyangsky
 * Date:        17/6/22 上午10:50
 * Method:      递归、回溯
 * Difficulty:  Medium
 */
public class L78Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), 0, nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> cur, int index, int[] nums) {

        ans.add(new ArrayList<>(cur));

        for (int i=index;i<nums.length;i++) {
            cur.add(nums[i]);
            dfs(ans, cur, i+1, nums);
            cur.remove(cur.size()-1);
        }
    }
}
