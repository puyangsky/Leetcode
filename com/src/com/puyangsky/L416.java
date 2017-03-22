package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/3/16
 * Complexity:
 * Method:
 */
public class L416 {
    public static boolean canPartition(int[] nums) {
        if(nums.length == 0) return false;
        int sum = 0;
        for(int i : nums)
            sum += i;
        return sum % 2 == 0 && helper(nums, sum / 2);
    }

    public static boolean helper(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<=sum;i++) dp[0][i] = false;
        for(int i=0;i<=n;i++) dp[i][0] = true;
        for(int i=1;i<=n;i++) {
            dp[i][sum] = dp[i-1][sum];
            if(sum >= nums[i-1]){
                dp[i][sum] |= dp[i-1][sum-nums[i-1]];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,5};
        System.out.println(canPartition(nums));
    }
}
