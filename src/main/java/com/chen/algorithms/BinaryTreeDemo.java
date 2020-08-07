package com.chen.algorithms;

import java.util.HashMap;

public class BinaryTreeDemo<Key extends Comparable<Key>, Value> {

    private Node root;

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        @Override
        public String toString() {
            return key + ", " + value;
        }
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("IllegalArgument of key");
        return get(root, key);
    }

    public Value get(Node x, Key key) {
        int i = key.compareTo(x.key);
        if (x == null) return null;
        if (i < 0) return get(x.left, key);
        else if (i > 0) return get(x.right, key);
        else return x.value;
    }

    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("IllegalArgument of key");
        root = put(root, key, value);
    }

    public Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);
        int i = key.compareTo(node.key);
        if (i < 0) node.left = put(node.left, key, value);
        else if (i > 0) node.right = put(node.right, key, value);
        else node.value = value;

        node.size = size(node.right) + size(node.left) + 1;
        return node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (root != null) {
            sb.append("=");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryTreeDemo btd = new BinaryTreeDemo();
        btd.put("sdfds", "Qweqw");
        btd.put("11", "22");
        System.out.println(btd);
    }
}
