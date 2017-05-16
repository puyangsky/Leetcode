package com.puyangsky;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: puyangsky
 * Date:   17/5/15
 * Method: 递归，回溯，全排列
 * TODO: TLE
 */
public class L47PermutationsII {
        static Set<List<Integer>> ans = new HashSet<>();

    public static void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void dfs(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            ans.add(list);
        }else {
            for (int i=index;i<nums.length;i++) {
                swap(nums, index, i);
                dfs(nums, index+1);
                swap(nums, i, index);
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(ans);
        dfs(nums, 0);
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int []nums = new int[]{1,1,2};
        List<List<Integer>> ans = permuteUnique(nums);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j));
                System.out.print(j==ans.get(i).size()-1?"\n":"\t");
            }
        }
    }
}
