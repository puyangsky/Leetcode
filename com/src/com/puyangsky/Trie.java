package com.puyangsky;


/**
 * Author: puyangsky
 * Date:   17/6/18
 * Method: Trie树
 */
public class Trie {
    private Node root;
    class Node{
        int count;
        char ch;
        Node[] child;
        boolean isEnd;

        public Node() {
            this.count = 1;
            this.child = new Node[26];
            this.isEnd = false;
        }
    }


    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word || "".equals(word)) return;
        if (this.search(word)) return;

        Node cur = this.root;
        char[] chars = word.toCharArray();
        for(char c : chars) {
            int pos = c - 'a';
            Node child = cur.child[pos];
            if (child == null) {
                cur.child[pos] = new Node();
                cur.child[pos].ch = c;
            }
            cur.count++;
            cur = cur.child[pos];
        }

        //最后一个字符的节点
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (null == word || "".equals(word)) return true;
        Node cur = this.root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            int pos = c - 'a';

            Node node = cur.child[pos];
            if (node == null) return false;

            cur = node;
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (null == prefix || "".equals(prefix)) return true;
        Node cur = this.root;
        char[] chars = prefix.toCharArray();
        for (char c : chars) {
            int pos = c - 'a';
            Node node = cur.child[pos];
            if (node == null) return false;
            cur = node;
        }

        return cur.count > 0;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("ab");
//        trie.insert("adc");
//        trie.insert("aer");

        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}
