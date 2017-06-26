package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/26 下午10:40
 * Method:      LinkedList
 * Difficulty:  Medium
 */
public class L142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        boolean flag = false;
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (!flag) return null;

        slow = head;
        while (true) {
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }
}
