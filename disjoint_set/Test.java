
public class Test {
    public static void main(String[] args) {
        int sampleSize = 10;
        testUF(new QuickFind(sampleSize), sampleSize);
        testUF(new QuickUnion(sampleSize), sampleSize);
        testUF(new WeightedQuickUnion(sampleSize), sampleSize);
        testUF(new QuickUnionWithPathCompression(sampleSize), sampleSize);
        testUF(new WeightedQUPCompression(sampleSize), sampleSize);
    }

    private static void testUF(DisjointSet uf, int sampleSize) {
        for (int i = 0; i < sampleSize - 1; i++)
            assert !uf.find(i, i + 1);

        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(8, 9);
        uf.union(5, 0);
        uf.union(7, 2);
        assert uf.find(0, 5);
        assert uf.find(6, 5);
        assert uf.find(1, 2);
        assert uf.find(1, 7);
        assert uf.find(8, 9);
        assert uf.find(3, 4);
        assert uf.find(3, 8);
        assert !uf.find(1, 0);
        assert !uf.find(1, 5);
        assert !uf.find(6, 7);
        assert !uf.find(6, 1);
        uf.union(6, 1);
        uf.union(1, 0);
        uf.union(6, 7);
        assert uf.find(1, 0);
        assert uf.find(1, 5);
        assert uf.find(6, 7);
        assert uf.find(6, 1);
        System.out.println(uf.getClass().getSimpleName() + ":" + uf);
    }
}
