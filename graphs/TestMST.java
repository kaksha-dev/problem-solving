
public class TestMST {
    public static void main(String[] args) {
        WeightedUndirectedGraph g = new WeightedUndirectedGraph(9);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(7, 1, 11);
        g.addEdge(2, 1, 8);
        g.addEdge(3, 2, 7);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(5, 2, 4);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
        g.addEdge(2, 8, 2);

        double sum = 0;
        /* 
        Kruskal kruskal = new Kruskal(g);
       
        for (WeightedEdge e : kruskal.getMst()) {
            sum += e.getW();
        }
        System.out.println(kruskal.getMst());
        System.out.println("cost of kruskal mst " + sum);
        assert sum==37;
        */

        Prims prims = new Prims(g);
        System.out.println(prims.getMst());
        sum = 0;
        for (WeightedEdge e : prims.getMst()) {
            sum += e.getW();
        }
        System.out.println("cost of prims mst " + sum);
        assert sum==37;
        PrimsFast prims2 = new PrimsFast(g);
        System.out.println(prims2.getMst());
        sum = 0;
        for (WeightedEdge e : prims2.getMst()) {
            sum += e == null ? 0 : e.getW();
        }
        System.out.println("cost of prims fast mst " + sum);
        assert sum==37;
    }

}
