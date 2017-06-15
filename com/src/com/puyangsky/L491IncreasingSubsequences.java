package com.puyangsky;

import java.util.*;

/**
 * Author: puyangsky
 * Date:   17/6/7
 */
public class L491IncreasingSubsequences {

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), nums, 0);
        return ans;
    }

    public static void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums, int pos) {
        if (cur.size() > 1) ans.add(new ArrayList<Integer>(cur));
        List<Integer> unique = new ArrayList<Integer>();
        for (int i=pos;i<nums.length;i++) {
            if (pos > 0 && nums[i] < nums[pos - 1]) continue;
            if (unique.contains(nums[i])) continue;
            unique.add(nums[i]);
            cur.add(nums[i]);
            dfs(ans, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

//    public static List<List<Integer>> findSubsequences(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        helper(res, new ArrayList<Integer>(), nums, 0);
//        return res;
//    }
//
//    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int id) {
//        if (list.size() > 1) res.add(new ArrayList<Integer>(list));
//        List<Integer> unique = new ArrayList<Integer>();
//        for (int i = id; i < nums.length; i++) {
//            if (id > 0 && nums[i] < nums[id-1]) continue; // skip non-increase
//            if (unique.contains(nums[i])) continue; // skip duplicate
//            unique.add(nums[i]);
//            list.add(nums[i]);
//            helper(res, list, nums, i+1);
//            list.remove(list.size()-1);
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> ans = findSubsequences(nums);
        System.out.println(ans);
        for (int i=0;i<ans.size();i++) {
            for (int j=0;j<ans.get(i).size();j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
