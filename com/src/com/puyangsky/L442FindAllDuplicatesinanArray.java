package com.puyangsky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/6/14
 * Method:
 */
public class L442FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) return ans;
        Arrays.sort(nums);
        int count = 0;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] == nums[i+1]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
