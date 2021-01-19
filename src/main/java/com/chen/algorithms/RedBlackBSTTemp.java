package com.chen.algorithms;

/**
 * 红黑树
 *
 * @param <Key>
 * @param <Value>
 * @author k3762
 */
public class RedBlackBSTTemp<Key extends Comparable<Key>, Value> {

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;
        private boolean color;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

    public void put(Key key, Value value) {
        if (key == null)
            new RuntimeException("参数异常");
        if (value == null) {

        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int comp = key.compareTo(node.key);
        if (comp < 0)
            node.left = put(node.left, key, value);
        else if (comp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.size = size(node.right) + size(node.left) + 1;
        return node;
    }

    private Value get(Node node, Key key) {
        int comp = key.compareTo(node.key);
        if (comp < 0)
            return get(node.left, key);
        else if (comp > 0)
            return get(node.right, key);
        else
            return node.value;
    }

    public Value get(Key key) {
        if (key == null)
            new RuntimeException("参数异常");
        if (root == null)
            return null;
        return get(root, key);
    }

    public int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    private Value getMin(Node node) {
        if (node == null)
            return null;
        if (node.left == null)
            return node.value;
        else
            return getMin(node.left);
    }

    public Value getMin() {
        if (root == null)
            return null;
        return getMin(root);
    }

    private Value getMax(Node node) {
        if (node == null)
            return null;
        if (node.right == null)
            return node.value;
        else
            return getMax(node.right);
    }

    public Value getMax() {
        if (root == null)
            return null;
        return getMax(root);
    }

    private Node select(Node node, int k) {
        if (node == null || k < 0)
            return null;
        int size = size(node.left);
        if (size > k)
            return select(node.left, k);
        else if (size < k)
            return select(node.right, k - size - 1);
        else
            return node;
    }

    public Value select(int k) {
        return select(root, k).value;
    }

    private Node deleteMin(Node node) {
        if (node == null) {
            new RuntimeException("数据为空");
        }
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right);
        return x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        return null;
    }

    public static void main(String[] args) {
        RedBlackBSTTemp<Integer, String> bs = new RedBlackBSTTemp<Integer, String>();
        bs.put(2, "222");
        bs.put(1, "111");
        bs.put(3, "333");
        bs.put(1, "444");

        System.out.println(bs.get(1));
        System.out.println(bs.get(2));
        System.out.println(bs.get(3));
        System.out.println("Min:" + bs.getMin());
        System.out.println("Max:" + bs.getMax());
        System.out.println("select:" + bs.select(2));

    }
}
