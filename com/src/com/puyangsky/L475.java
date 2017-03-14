package com.puyangsky;

import java.util.Arrays;

/**
 * Author: puyangsky
 * Complexity: O(NlogN)
 * Method: 改进版二分查找，返回距离target最近的下标
 */
public class L475 {
    public static int findRadius(int[] houses, int[] heaters) {
        if(houses.length == 0 || heaters.length == 0) return -1;
        int max = 0; Arrays.sort(heaters);
        for(int i : houses) {
            int temp = binarySearch(i, heaters);
            int distance = heaters[temp] > i ? heaters[temp] - i : i - heaters[temp];
            max = max > distance ? max : distance;
        }
        return max;
    }

    public static int binarySearch(int target, int[] heaters) {
        int left = 0, right = heaters.length-1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(heaters[mid] == target) {
                return mid;
            }else if(heaters[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        //此时left=right，并且没有找到相等的点，需要判断target离左右两个点哪个更近一些，left-1,left,left+1
        int minIndex = left, distance = Math.abs(heaters[left] - target);
        if(left >0) {
             if(distance > Math.abs(heaters[left-1] - target)) {
                 minIndex = left - 1;
                 distance = Math.abs(heaters[left-1] - target);
             }
        }
        if(left < heaters.length -1) {
            if(distance > Math.abs(heaters[left+1] - target)) {
                minIndex = left + 1;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(houses, heaters));
    }
}
