package com.puyangsky;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: puyangsky
 * Date:   17/5/15
 * Method: Backtracking
 */
public class L113PathSum2 {
    List<List<Integer>> ans = new ArrayList<>();

        public void dfs(TreeNode node, int cur, Stack<Integer> path) {

        path.push(node.val);
        if (node.left == null && node.right == null) {
            if (cur == node.val) {
                ans.add(new ArrayList<Integer>(path));
            }
        }
        if (node.left != null)
            dfs(node.left, cur-node.val, path);
        if (node.right != null)
            dfs(node.right, cur-node.val, path);
        //删除最后加进来的元素，以便下次循环重新开始
        path.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        Stack<Integer> path = new Stack<>();
        dfs(root, sum, path);
        return ans;
    }
}
