
public class QuickUnionWithPathCompression extends QuickUnion {
    public QuickUnionWithPathCompression(int size) {
        super(size);
    }

    @Override
    public int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]];  //path compression
            i = id[i];
        }
        return i;
    }
}
