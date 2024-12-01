import java.util.HashSet;
import java.util.Set;

public class RBTTree<K extends Comparable<K>, V> implements BST<K, V> {
    private final Set<K> rotationKeys = new HashSet<>();

    private int rotationCount = 0;
    private Node root;

    private int maxRotations;
    private int maxRotationsTemp;

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
        if (color(n.left) != Node.RED && color(n.right) == Node.RED) {
            n = leftRotate(n);
        }
        if (color(n.left) == Node.RED && color(n.left.left) == Node.RED) {
            n = rightRotate(n);
        }
        if (color(n.left) == Node.RED && color(n.right) == Node.RED) {
            flipColor(n);
        }
        return n;
    }

    private void flipColor(Node n) {
        rotationKeys.add(n.k);
        n.left.color = n.color;
        n.right.color = n.color;
        n.color = Node.RED;
    }

    private boolean color(Node n) {
        return n == null ? Node.BLACK : n.color;
    }

    private Node leftRotate(Node n) {
        rotationKeys.add(n.k);
        rotationCount++;
        maxRotationsTemp++;
        Node t = n.right;
        n.right = t.left;
        t.left = n;
        t.color = n.color;
        n.color = Node.RED;
        return t;
    }

    private Node rightRotate(Node n) {
        rotationKeys.add(n.k);
        rotationCount++;
        maxRotationsTemp++;
        Node t = n.left;
        n.left = t.right;
        t.right = n;
        t.color = n.color;
        n.color = Node.RED;
        return t;
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
    public int totalTime() {
        return (int) totalTime;
    }


    @Override
    public void insert(K k, V v) {
        this.maxRotationsTemp = 0;
        long startTime = System.currentTimeMillis();
        root = insert(root, k, v);
        totalTime += System.currentTimeMillis() - startTime;
        root.color = Node.BLACK;
        this.maxRotations = Math.max(this.maxRotations, this.maxRotationsTemp);
    }

    private class Node {
        public static final boolean RED = true;
        public static final boolean BLACK = false;
        private final K k;
        private boolean color;
        private V v;

        private Node left;
        private Node right;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
            this.color = RED;
        }
    }
}
