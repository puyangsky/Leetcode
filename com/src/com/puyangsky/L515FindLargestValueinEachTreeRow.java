package com.puyangsky;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Author:      puyangsky
 * Date:        下午12:42
 * Method:      树的层次遍历
 * Difficulty:  Medium
 */
public class L515FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null ) return ans;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() > 0) {
            int queueSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if (max < node.val) {
                    max = node.val;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            ans.add(max);
        }

        return ans;
    }
}
