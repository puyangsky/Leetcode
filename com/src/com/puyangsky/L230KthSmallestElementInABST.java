package com.puyangsky;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: puyangsky
 * Date: 17/4/24
 */
public class L230KthSmallestElementInABST {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        if (preOrder(root.left).size() != 0)
            list.addAll(preOrder(root.left));

        list.add(root.val);

        if (preOrder(root.right).size() != 0)
            list.addAll(preOrder(root.right));

        return list;
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k <= 0) return -1;
        int left = count(root.left);

        if (left >= k)
            return kthSmallest(root.left, k);

        if (left < k - 1)
            return kthSmallest(root.right, k-left-1);

        return root.val;
    }

    public int count(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + count(node.left) + count(node.right);
    }

}
