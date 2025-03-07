
import java.util.Arrays;

public class IndexPQ<K extends Comparable<K>> {
    private final K[] keys;
    private final int[] pq;
    private final int[] qp;
    private int n = 0;

    public IndexPQ(int size) {
        keys = (K[]) new Comparable[size];
        pq = new int[size];
        qp = new int[size];
        Arrays.fill(qp, -1);
    }

    public void insert(int v, K key) {
        pq[n] = v;
        qp[v] = n;
        keys[v] = key;
        swim(n);
        n++;
    }

    private void swim(int i) {
        if (i == 0) return;
        int p = i / 2;
        if (keys[pq[p]].compareTo(keys[pq[i]]) > 0) {
            swap(i, p);
            swim(p);
        }
    }

    public int delMin() {
        if (size() == 0) throw new RuntimeException("Underflow");
        int v = pq[0];
        swap(0, n - 1);
        n--;
        sink(0);
        keys[pq[n]] = null;
        qp[pq[n]] = -1;
        return v;
    }

    private void swap(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void sink(int i) {
        if (i > n / 2) return;
        int l = i * 2;
        int r = i * 2 + 1;
        int min = i;
        if (l < n && keys[pq[l]].compareTo(keys[pq[min]]) < 0) min = l;
        if (r < n && keys[pq[r]].compareTo(keys[pq[min]]) < 0) min = r;
        if (min != i) {
            swap(i, min);
            sink(min);
        }
    }

    public void decreaseKey(int v, K key) {
        int cmp = keys[v].compareTo(key);
        keys[v] = key;
        if (cmp == 0) return;
        if (cmp > 0)
            swim(qp[v]);
        else
            sink(qp[v]);
    }

    public boolean hasKey(int v) {
        return qp[v] != -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int size() {
        return n;
    }

    @Override
    public String toString() {
        return "IndexPQ{" +
                "keys=" + Arrays.toString(keys) +
                ", pq=" + Arrays.toString(pq) +
                ", qp=" + Arrays.toString(qp) +
                ", n=" + n +
                '}';
    }
}
