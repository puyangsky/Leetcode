package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/6/15
 * Method:
 */
public class L377CombinationSumIV {

    /*
    public static void dfs(int left, int[] nums, List<Integer> cur, Set<List<Integer>> ans) {
        if (left == 0) {
            List<Integer> list = new ArrayList<>(cur);
            ans.add(list);
            return;
        }

        if (left < 0)

            return;

        for (int i : nums) {
            cur.add(i);
            dfs(left-i, nums, cur, ans);
            cur.remove(cur.size()-1);
        }
    }
    public static int combinationSum4(int[] nums, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        if (nums.length == 0 || target == 0) {
            return 0;
        }
        dfs(target, nums, new ArrayList<>(), ans);

        return ans.size();
    }
    */

    public static int combinationSum4(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }

        /**
         * dp[i]代表了target为i时有多少种方法
         */

        int[] dp = new int[target+1];

        for (int i = 0; i <= target ; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int k : nums) {
                if (i >= k) {
                    dp[i] += dp[i-k];
                }
            }
        }

        return dp[target];

//        int res = 0;
//        for (int i : nums) {
//            if (target >= i) {
//                res += combinationSum4(nums, target - i);
//            }
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums, 4));
    }
}
