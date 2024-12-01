import java.util.HashSet;
import java.util.Set;

public class AVLTree<K extends Comparable<K>, V> implements BST<K, V> {
    private final Set<K> rotationKeys = new HashSet<>();
    private Node root;

    private int rotationCount = 0;
    private int maxRotationsTemp;
    private int maxRotations;

    private long totalTime;

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
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        int diff = getHeight(n.left) - getHeight(n.right);
        if (diff == 2) {
            if (getHeight(n.left.left) - getHeight(n.left.right) == -1) {
                n.left = leftRotate(n.left);
            }
            n = rightRotate(n);

        } else if (diff == -2) {
            if (getHeight(n.right.left) - getHeight(n.right.right) == 1) {
                n.right = rightRotate(n.right);
            }
            n = leftRotate(n);
        }
        return n;
    }

    private Node leftRotate(Node n) {
        rotationKeys.add(n.k);
        rotationCount++;
        maxRotationsTemp++;
        Node t = n.right;
        n.right = t.left;
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        t.left = n;
        return t;
    }

    private Node rightRotate(Node n) {
        rotationKeys.add(n.k);
        rotationCount++;
        maxRotationsTemp++;
        Node t = n.left;
        n.left = t.right;
        n.h = 1 + Math.max(getHeight(n.left), getHeight(n.right));
        t.right = n;
        return t;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.h;
    }

    @Override
    public int height() {
        return height(root);
    }

    private int height(Node n) {
        if (n == null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

    @Override
    public int rotations() {
        return rotationKeys.size();
    }

    @Override
    public int totalRotations() {
        return this.rotationCount;
    }

    @Override
    public int maxRotations() {
        return this.maxRotations;
    }

    @Override
    public void insert(K k, V v) {
        this.maxRotationsTemp = 0;
        long startTime = System.currentTimeMillis();
        root = insert(root, k, v);
        totalTime += System.currentTimeMillis() - startTime;
        this.maxRotations = Math.max(this.maxRotations, this.maxRotationsTemp);
    }

    @Override
    public int totalTime() {
        return (int)totalTime;
    }

    private class Node {
        private int h;
        private final K k;
        private V v;

        private Node left;
        private Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.h = 1;
        }
    }
}
