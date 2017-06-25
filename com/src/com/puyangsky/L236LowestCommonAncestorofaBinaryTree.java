package com.puyangsky;

/**
 * Author:      puyangsky
 * Date:        17/6/25 下午9:39
 * Method:
 * Difficulty:
 */
public class L236LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        else return l != null ? l : r;
    }
}
