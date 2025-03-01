import java.util.Arrays;

public abstract class DisjointSet {
    protected int[] id;

    public DisjointSet(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    protected abstract boolean find(int i, int j);

    protected abstract void union(int i, int j);

    @Override
    public String toString() {
        return Arrays.toString(id);
    }
}
