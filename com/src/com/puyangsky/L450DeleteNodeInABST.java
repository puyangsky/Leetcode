package com.puyangsky;

/**
 * Author: puyangsky
 * Date: 17/4/22
 *         3
 *        / \
 *       1  5    ==>
 *      /\  /\
 *     0 2 4 6
 */
public class L450DeleteNodeInABST {

    TreeNode findMin(TreeNode node) {
        TreeNode p = node.left;
        while (p.right != null)
            p = p.right;
        return p;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) root.right = deleteNode(root.right, key);
        else if (root.val > key) root.left = deleteNode(root.left, key);
        else {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                TreeNode min = findMin(root);
                root.val = min.val;
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }

}
