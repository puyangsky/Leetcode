package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/24 下午1:16
 * Method:      从前向后更新每一步能走的最远的路程
 * Difficulty:  Medium
 */
public class L55JumpGame {
    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(max, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,0,0,4};
        System.out.println(canJump(nums));
    }
}
