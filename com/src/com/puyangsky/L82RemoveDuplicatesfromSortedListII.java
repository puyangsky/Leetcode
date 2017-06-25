package com.puyangsky;


/**
 * Author:      puyangsky
 * Date:        17/6/22 上午11:31
 * Method:
 * Difficulty:
 */
public class L82RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prePre = new ListNode(0);
        prePre.next = head;
        ListNode ans = prePre;
        ListNode pre = head;

        ListNode node = head.next;
        int delete = head.val;
        while (node != null) {
            //删除当前节点
            if (node.val == delete) {
                // 删除node
                pre.next = node.next;
                node = pre.next;

                //删除pre
                prePre.next = pre.next;
                pre = prePre.next;
            }else {
                delete = node.val;
//                prePre = pre;
                pre = node;
                node = node.next;
            }
        }
        return ans.next;
    }
}
