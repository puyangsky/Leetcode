package com.puyangsky;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:      puyangsky
 * Date:        17/6/20 下午3:53
 * Method:
 * Difficulty:
 */
public class L513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        int left = -1;
        if (root == null) return left;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (i==0) left = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return left;
    }
}
