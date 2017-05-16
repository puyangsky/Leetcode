package com.puyangsky;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: puyangsky
 * Date:   17/5/16
 * Method:
 */
public class L114FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;
        TreeNode tmp = root;

        while (tmp.right != null)
            tmp = tmp.right;

        tmp.right = right;
    }
}
