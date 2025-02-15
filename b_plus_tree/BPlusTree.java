public class BPlusTree<K extends Comparable<K>, V> {
    private final int MAX_DEGREE = 4;
    private int height = 0;
    private int count = 0;
    private Node root;

    public BPlusTree() {
        root = new Node(0);
    }

    public void insert(K key, V val) {
        boolean isFound = search(key) != null;
        Node t = insert(root, key, val, height);
        if (!isFound) count++;
        if (t == null) {
            return;
        }
        Node x = new Node(2);
        x.children[0] = new Entry(root.children[0].key, null, root);
        x.children[1] = new Entry(t.children[0].key, null, t);
        root = x;
        height++;
    }

    private Node insert(Node n, K key, V val, int h) {
        Entry e = new Entry(key, val, null);
        int j = 0;
        if (h == 0) {
            for (; j < n.degree; j++) {
                if (key.compareTo(n.children[j].key) == 0) {
                    //update case
                    n.children[j].val = val;
                    return null;
                }
                if (key.compareTo(n.children[j].key) < 0) break;
            }
        } else {
            for (; j < n.degree; j++) {
                if (j == n.degree - 1 || key.compareTo(n.children[j + 1].key) < 0) {
                    Node newNode = insert(n.children[j++].next, key, val, h - 1);
                    if (newNode == null) return null;
                    e.val = null;
                    e.key = newNode.children[0].key;
                    e.next = newNode;
                    break;
                }
            }
        }
        for (int i = n.degree; i > j; i--) {
            n.children[i] = n.children[i - 1];
        }
        n.children[j] = e;
        n.degree++;
        if (n.degree < MAX_DEGREE) return null;
        return split(n);
    }

    private Node split(Node n) {
        Node t = new Node(MAX_DEGREE / 2);
        for (int i = 0; i < MAX_DEGREE / 2; i++) {
            t.children[i] = n.children[MAX_DEGREE / 2 + i];
            n.children[MAX_DEGREE / 2 + i] = null;
        }
        n.degree = MAX_DEGREE / 2;
        return t;
    }

    public V search(K key) {
        return search(root, key, height);
    }

    private V search(Node n, K key, int h) {
        if (h == 0) {
            for (int i = 0; i < n.degree; i++) {
                if (key.compareTo(n.children[i].key) == 0) return n.children[i].val;
            }
            return null;
        }
        for (int i = 0; i < n.degree; i++) {
            if (i == n.degree - 1 || key.compareTo(n.children[i + 1].key) < 0)
                //search element in child of node <= key or child of last node
                return search(n.children[i].next, key, h - 1);
        }
        return null;
    }

    public int size() {
        return count;
    }

    public int height() {
        return height;
    }

    private class Entry {
        private Node next;
        private K key;
        private V val;

        public Entry(K key, V val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }

    }

    private class Node {
        private final Entry[] children = new BPlusTree.Entry[MAX_DEGREE];
        private int degree;

        public Node(int degree) {
            this.degree = degree;
        }
    }
}
