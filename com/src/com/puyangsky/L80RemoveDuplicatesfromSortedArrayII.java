package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/5/24
 * Method:
 * TODO 有问题，如何改变数组内容
 */
public class L80RemoveDuplicatesfromSortedArrayII {
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        int i = 0, flag = 1, ans = len;
        while (i < len - 1) {
            if (nums[i] == nums[i+1]) {
                flag--;
            }else {
                flag = 1;
            }
            if (flag < 0) {
                ans--;
                if (i == list.size())
                    break;
                list.remove(i);
            }
            i++;
        }
        for (i=0;i<list.size();i++) {
            nums[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
