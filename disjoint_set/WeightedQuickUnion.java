
public class WeightedQuickUnion extends QuickUnion {
    private final int[] sz;

    public WeightedQuickUnion(int size) {
        super(size);
        sz = new int[size];
        for (int i = 0; i < size; i++)
            sz[i] = 1;
    }

    @Override
    public void union(int i, int j) {
        int x = root(i);
        int y = root(j);
        if (sz[x] > sz[y]) {
            id[y] = x;
            sz[x] += sz[y];
        } else {
            id[x] = y;
            sz[y] += sz[x];
        }
    }

}
