
import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
    private Node head;
    private int size;
    public void insert(T data) {
        head = insert(head, data);
        size++;
    }

    private Node insert(Node n, T data) {
        if (n == null) return new Node(data);
        n.next = insert(n.next, data);
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = head;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                Node n = temp;
                temp = temp.next;
                return n.data;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : this) {
            sb.append(t).append("->");
        }
        return sb.length() > 2 ? sb.substring(0, sb.length() - 2) : null;
    }

    public int size() {
        return size;
    }

    private class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
