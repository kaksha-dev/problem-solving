public class AVLTree<K extends Comparable<K>, V> {
    private Node root;

    public void insert(K k, V v) {
        root = insert(root, k, v);
    }

    private Node insert(Node n, K k, V v) {
        if (n == null) return new Node(k, v);
        int comp = k.compareTo(n.k);
        if (comp > 0) {
            n.right = insert(n.right, k, v);
        } else if (comp < 0) {
            n.left = insert(n.left, k, v);
        } else {
            n.v = v; //update
        }
        int diff = getHeight(n.left) - getHeight(n.right);
        if (diff > 1) {
            if (getHeight(n.left.left) - getHeight(n.left.right) == -1) {
                n.left = leftRotate(n.left);
            }
            n = rightRotate(n);

        } else if (diff < -1) {
            if (getHeight(n.right.left) - getHeight(n.right.right) == 1) {
                n.right = rightRotate(n.right);
            }
            n = leftRotate(n);
        }
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        return n;
    }

    private Node rightRotate(Node n) {
        Node t = n.left;
        n.left = t.right;
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        t.right = n;
        return t;
    }

    private Node leftRotate(Node n) {
        Node t = n.right;
        n.right = t.left;
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        t.left = n;
        return t;
    }

    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.h;
    }

    private class Node {
        private final K k;
        private V v;

        private Node left;
        private Node right;

        private int h;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.h = 1;
        }
    }

}
