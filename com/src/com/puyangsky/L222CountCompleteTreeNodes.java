package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/26 下午8:30
 * Method:
 * Difficulty:
 */
public class L222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int l = heightOfLeft(root), r = heightOfRight(root);
        if (l == r) return (1 << l) - 1;
        return 1 + countNodes(root.right) + countNodes(root.left);
    }

    int heightOfLeft(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        while (root != null) {
            root = root.left;
            h++;
        }
        return h;
    }

    int heightOfRight(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
}
