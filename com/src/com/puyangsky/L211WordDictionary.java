package com.puyangsky;

/**
 * Author: puyangsky
 * Date:   17/6/19
 * Method: Trie + 回溯
 */
public class L211WordDictionary {

    class Node {
        Node[] child;
        boolean isEnd;

        public Node() {
            this.child = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public L211WordDictionary() {
        this.root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (null == word || "".equals(word)) return;

        char[] chars = word.toCharArray();
        Node cur = root;
        for (char ch : chars) {
            int pos = ch - 'a';
            Node child = cur.child[pos];

            if (child == null) {
                cur.child[pos] = new Node();
            }
            cur = cur.child[pos];
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (null == word || "".equals(word)) return true;
        return match(word.toCharArray(), root, 0);
    }


    public boolean match(char[] chars, Node node, int index) {
        if (index == chars.length) {
            return node.isEnd;
        }

        boolean ans = false;

        if (chars[index] == '.') {
            for (int j=0;j<26;j++) {
                if (node.child[j] != null) {
                    ans = ans || match(chars, node.child[j], index+1);
                }
            }
        }else {
            int pos = chars[index] - 'a';
            if (node.child[pos] == null) return false;
            else {
                return match(chars, node.child[pos], index + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        L211WordDictionary dictionary = new L211WordDictionary();

        dictionary.addWord("a");
        dictionary.addWord("dbc");
        dictionary.addWord("ebc");

//        System.out.println(dictionary.search("abc"));
        System.out.println(dictionary.search(".bc"));
        System.out.println(dictionary.search("."));
        System.out.println(dictionary.search("d"));
    }
}
