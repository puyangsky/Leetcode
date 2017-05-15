package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/4/24
 */
public class L230KthSmallestElementInABST {

    int getCount(TreeNode node) {
        if (node == null) return 0;
        return 1 + getCount(node.left) + getCount(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;
        int total = getCount(root);
        int left = getCount(root.left);
        if (k > total) return -1;
        if (k <= left) {
            
        }
        return -1;
    }
}
