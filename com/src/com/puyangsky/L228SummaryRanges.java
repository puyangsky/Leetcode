package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:      puyangsky
 * Date:        17/6/25 下午9:51
 * Method:
 * Difficulty:
 */
public class L228SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int start = nums[0], i = 1, end = nums[0];
        while (i < nums.length) {
            if (nums[i] == nums[i-1] + 1) {
                end = nums[i];
            }else {
                if (start == end) ans.add(String.valueOf(start));
                else
                    ans.add(start + "->" + end);
                start = nums[i];
                end = nums[i];
            }
            i++;
        }
        if (start == end) ans.add(String.valueOf(start));
        else ans.add(start + "->" + end);

        return ans;
    }
}
