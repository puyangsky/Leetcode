package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/5/16
 * Method: 递归
 * TODO：  为什么对ListNode数组的归并中，顺序从0到len-1的归并会超时，而使用递归的方法可以不超时呢？
 */
public class L23MergeKSortedLists {

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        if (a.val < b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        }else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }

    public ListNode mergeKLists(ListNode[] lists, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            return mergeTwoLists(mergeKLists(lists,left,mid),mergeKLists(lists,mid+1,right));
        }
        return lists[left];
    }


    public ListNode mergeKLists(ListNode[] lists) {

        int len = lists.length;
        if (len == 0) return null;
        return mergeKLists(lists, 0, len-1);
    }
}
