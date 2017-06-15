package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/6/15
 * Method:
 * TODO
 */
public class L449SerializeandDeserializeBST {

}
class Codec {

    public void travel(TreeNode root) {

    }

    String SEPARATOR = "\t";
    String NULL = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        if (root == null) {
            ans += NULL;
            return ans + SEPARATOR;
        }else {
            ans += root.val;
        }
        ans += SEPARATOR;

        ans += serialize(root.left);
        ans += serialize(root.right);

        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return null;
    }
}