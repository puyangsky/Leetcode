package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/5/24
 * Method: DFS
 */
public class L129SumRoottoLeafNumbers {

    private int ans = 0;

    public void dfs(TreeNode node, int cur) {
        if (node == null)
            return;
        else
            cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) {
            ans += cur;
        }else {
            dfs(node.left, cur);
            dfs(node.right, cur);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
}
