public class AVLTreeSizeBased<K extends Comparable<K>, V> {
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
        int diff = sizeOf(n.left) - sizeOf(n.right);
        if (diff > 1) {
            if (sizeOf(n.left.left) - sizeOf(n.left.right) == -1) {
                n.left = leftRotate(n.left);
            }
            n = rightRotate(n);

        } else if (diff < -1) {
            if (sizeOf(n.right.left) - sizeOf(n.right.right) == 1) {
                n.right = rightRotate(n.right);
            }
            n = leftRotate(n);
        }
        n.size = 1+ sizeOf(n.left) + sizeOf(n.right);
        return n;
    }

    private Node rightRotate(Node n) {
        Node t = n.left;
        n.left = t.right;
        n.size = 1+ sizeOf(n.left) + sizeOf(n.right);
        t.right = n;
        return t;
    }

    private Node leftRotate(Node n) {
        Node t = n.right;
        n.right = t.left;
        n.size = 1+ sizeOf(n.left) + sizeOf(n.right);
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

    private int sizeOf(Node node) {
        return node == null ? 0 : node.size;
    }

    private class Node {
        private final K k;
        private V v;

        private Node left;
        private Node right;

        private int size;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.size = 0;
        }
    }

}
