import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BPlusTree<K extends Comparable<K>, V> {
    private final int DEGREE = 4;
    private Node root;
    private int height = 0;
    private int count = 0;

    public BPlusTree() {
        root = new Node(0);
    }

    public V search(K key) {
        return search(root, key, height);
    }

    private V search(Node n, K key, int h) {
        if (h == 0) {
            for (int i = 0; i < n.size; i++) {
                if (key.compareTo(n.children[i].key) == 0) {
                    return n.children[i].value;
                }
            }
            return null;
        }
        for (int i = 0; i < n.size; i++) {
            if (i == n.size - 1 || key.compareTo(n.children[i + 1].key) < 0) {
                return search(n.children[i].next, key, h - 1);
            }
        }
        return null;
    }

    public void insert(K key, V value) {
        Node temp = insert(root, key, value, height);
        count++;
        if (temp == null) {
            return;
        }
        height++;
        Node newNode = new Node(2);
        newNode.children[0] = new Entry(root.children[0].key, null, root);
        newNode.children[1] = new Entry(temp.children[0].key, null, temp);
        root = newNode;
    }

    private Node insert(Node n, K key, V value, int h) {
        int i = 0;
        Entry e = new Entry(key, value, null);
        if (h == 0) {
            for (; i < n.size; i++) {
                if (key.compareTo(n.children[i].key) == 0) {
                    n.children[i].value = value; //update case
                    return null;
                }
                // if (i == n.size - 1 || key.compareTo(n.children[i + 1].key) < 0) {
                if (key.compareTo(n.children[i].key) < 0) break;
            }

        } else {
            for (; i < n.size; i++) {
                if (i == n.size - 1 || key.compareTo(n.children[i + 1].key) < 0) {
                    Node newNode = insert(n.children[i].next, key, value, h - 1);
                    if (newNode == null) {
                        return null;
                    }
                    e.key = newNode.children[0].key;
                    e.value = null;
                    e.next = newNode;
                    i++;
                    break;

                }
            }
        }
        for (int j = n.size; j > i; j--) {
            //shift element  cost O(DEGREE)
            n.children[j] = n.children[j - 1];
        }
        n.children[i] = e;
        n.size++;
        if (n.size < DEGREE) {
            return null;
        }
        return split(n);
    }

    private Node split(Node n) {
        //assume DEGREE is even number
        Node temp = new Node(DEGREE / 2);
        for (int i = 0; i < DEGREE / 2; i++) {
            temp.children[i] = n.children[DEGREE / 2 + i];
            n.children[DEGREE / 2 + i] = null;
        }
        n.size = DEGREE / 2;
        return temp;
    }

    public int size() {
        return count;
    }

    public int height() {
        return height;
    }

    public void levelOrder() {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root, null));
        int level = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (level < p.level) {
                level = p.level;
                System.out.println();
            }
            System.out.print(" " + p.parentId + ":" + p.n);
            for (int i = 0; i < p.n.size; i++) {
                if (p.n.children[i].next != null)
                    q.add(new Pair(p.level + 1, p.n.children[i].next, p.n.children[i].key));
            }
        }

    }

    private class Node {
        private final Entry[] children = new BPlusTree.Entry[DEGREE];
        private int size;

        public Node(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return Arrays.toString(children);
        }
    }

    private class Entry {
        private K key;
        private Node next;
        private V value;

        public Entry(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return value == null ? key.toString() + "*" : key.toString();
        }
    }

    private class Pair {
        int level;
        Node n;
        K parentId;

        public Pair(int level, Node n, K parentId) {
            this.level = level;
            this.n = n;
            this.parentId = parentId;
        }
    }
}
