
public class QuickFind extends DisjointSet {

    public QuickFind(int size) {
        super(size);
    }

    @Override
    protected boolean find(int i, int j) {
        return id[i] == id[j];
    }

    @Override
    protected void union(int i, int j) {
        int x = id[i];
        int y = id[j];
        for (int k = 0; k < id.length; k++) {
            if (id[k] == x)
                id[k] = y;
        }
    }
}
