package com.puyangsky;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author:      puyangsky
 * Date:        17/6/21 下午11:02
 * Method:
 * Difficulty:
 */
public class L173BinarySearchTreeIterator {
    class BSTIterator {

        Deque<Integer> queue;
        public BSTIterator(TreeNode root) {
            this.queue = new ArrayDeque<>();
            travel(root);
        }

        private void travel(TreeNode node) {
            if (node == null) return;
            travel(node.left);
            queue.addLast(node.val);
            travel(node.right);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return queue.size() == 0;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (!hasNext()) return -1;
            return queue.pollFirst();
        }
    }

}
