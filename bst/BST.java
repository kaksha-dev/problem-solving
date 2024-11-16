

public class BST<K extends Comparable<K>, V> {
    private Node root;

    public K fca(K k1, K k2) {
        if (search(root, k1) == null || search(root, k2) == null) return null;
        return fca(root, k1, k2, null);
    }

    private K fca(Node n, K k1, K k2, Node p) {
        int comp1 = k1.compareTo(n.k);
        int comp2 = k2.compareTo(n.k);
        if ((comp2 < 0 && comp1 > 0) || (comp2 > 0 && comp1 < 0)) return n.k;
        if (comp2 > 0 && comp1 > 0) return fca(n.right, k1, k2, n);
        if (comp2 < 0 && comp1 < 0) return fca(n.left, k1, k2, n);
        return p == null ? null : p.k; // k1 == n.k or k2 == n.k
    }

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
        return n;
    }

    public V search(K k) {
        Node t = search(root, k);
        return t == null ? null : t.v;
    }

    private Node search(Node n, K k) {
        if (n == null) return null;
        int comp = k.compareTo(n.k);
        if (comp > 0) {
            return search(n.right, k);
        }
        if (comp < 0) {
            return search(n.left, k);
        }
        return n;
    }


    public K getMin() {
        if (root == null) return null;
        Node n = getMin(root);
        return n.k;
    }

    private Node getMin(Node n) {
        if (n.left == null) {
            return n;
        }
        return getMin(n.left);
    }

    public void delMin() {
        if (root == null) return;
        root = delMin(root);
    }

    private Node delMin(Node n) {
        if (n.left == null) {
            return n.right;
        }
        n.left = delMin(n.left);
        return n;
    }

    public void del(K k) {
        root = del(root, k);
    }

    private Node del(Node n, K k) {
        if (n == null) return null;
        int comp = k.compareTo(n.k);
        if (comp > 0) {
            n.right = del(n.right, k);
        } else if (comp < 0) {
            n.left = del(n.left, k);
        } else {
            if (n.left == null) {
                //case 1 and 2
                return n.right;
            }
            if (n.right == null) {
                //case 3
                return n.left;
            }
            //case 4
            Node t = getMin(n.right); // t has not left but some right
            t.right = delMin(n.right);
            t.left = n.left;
            return t;
        }
        return n;
    }

    private class Node {
        private final K k;
        private V v;

        private Node left;
        private Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }

}
