
public class QuickUnion extends DisjointSet {
    public QuickUnion(int size) {
        super(size);
    }

    @Override
    public boolean find(int i, int j) {
        return root(i) == root(j);
    }

    @Override
    public void union(int i, int j) {
        int x = root(i);
        int y = root(j);
        id[x] = y;
    }

    public int root(int i) {
        while (id[i] != i)
            i = id[i];
        return i;
    }
}
