package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/3/14
 * Complexity: Time O(logN) Space O(1)
 * Method: 二分查找
 */
public class L278 {
    public boolean isBadVersion(int version) {
        return true;
    }
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
//            int mid = (left + right) >>> 1;
            int mid = left + (right - left) / 2;
            //如果中位数为bad，则中位数右边都为bad
            if(isBadVersion(mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
