package com.puyangsky;

import java.util.Stack;

/**
 * Created by puyangsky on 17/3/12.
 */
public class L455 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        Stack<ListNode> s3 = new Stack<ListNode>();

        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1);
            p1 = p1.next;
        }

        while (p2 != null) {
            s2.push(p2);
            p2 = p2.next;
        }

        int carry = 0;
        while(!s1.empty() && !s2.empty()) {
            int v = s1.peek().val + s2.peek().val + carry;
            //更新进位
            if(v >= 10) {
                carry = 1;
                v -= 10;
            }else
                carry = 0;

            ListNode node = new ListNode(v);
            s3.push(node);
            s1.pop(); s2.pop();
        }

        while (!s1.empty()) {
            int v = s1.peek().val + carry;
            //更新进位
            if (v >= 10) {
                carry = 1;
                v -= 10;
            } else
                carry = 0;

            ListNode node = new ListNode(v);
            s3.push(node);
            s1.pop();
        }

        while (!s2.empty()) {
            int v = s2.peek().val + carry;
            //更新进位
            if(v >= 10) {
                carry = 1;
                v -= 10;
            }else
                carry = 0;

            ListNode node = new ListNode(v);
            s3.push(node);
            s2.pop();
        }

        if(carry == 1) {
            ListNode node = new ListNode(1);
            s3.push(node);
        }

        ListNode head = s3.peek();
        ListNode p = head;
        s3.pop();
        while (!s3.empty()) {
            p.next = s3.peek();
            s3.pop();
            p = p.next;
        }

        return head;
    }
}
