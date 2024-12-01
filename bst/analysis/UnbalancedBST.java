public class UnbalancedBST<K extends Comparable<K>, V> implements BST<K, V> {

    private Node root;

    private long totalTime;

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
        return 0;
    }

    @Override
    public int totalRotations() {
        return 0;
    }

    @Override
    public int maxRotations() {
        return 0;
    }

    @Override
    public int totalTime() {
        return (int)totalTime;
    }


    @Override
    public void insert(K k, V v) {
        long startTime = System.currentTimeMillis();
        root = insert(root, k, v);
        totalTime += System.currentTimeMillis()-startTime;
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
