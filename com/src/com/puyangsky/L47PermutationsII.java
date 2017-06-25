package com.puyangsky;

import java.util.*;

/**
 * Author: puyangsky
 * Date:   17/5/15
 * Method: 递归，回溯，全排列
 */
public class L47PermutationsII {
    static List<List<Integer>> ans = new ArrayList<>();

    public static void dfs(int[] nums, List<Integer> cur, boolean[] used) {
        if (cur.size() == nums.length) {
            List<Integer> list = new ArrayList<>(cur);
            ans.add(list);
        }else {
            for (int i=0;i<nums.length;i++) {
                if (used[i]) continue;
                if (i>0 && nums[i-1] == nums[i] && !used[i-1]) continue;
                cur.add(nums[i]);
                used[i] = true;
                dfs(nums, cur, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(ans);
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), used);
        return ans;
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,1,3};
        List<List<Integer>> ans = permuteUnique(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(j==ans.get(i).size()-1?"\n":"\t");
            }
        }
    }
}
