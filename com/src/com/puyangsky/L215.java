package com.puyangsky;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by puyangsky on 17/3/1.
 */
public class L215 {

    public static int findKthLargest(int[] nums, int k) {
        if (k<=0 || nums.length < k || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i : nums) {
            queue.offer(i);
        }

        for(int i = 0;i<k-1;i++) {
            queue.poll();
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        int []a = new int[]{4,1,2,5,6};

        System.out.println(findKthLargest(a, 2));
    }

}
