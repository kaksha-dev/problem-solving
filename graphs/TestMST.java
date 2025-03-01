
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

        Kruskal kruskal = new Kruskal(g);
        double sum = 0;
        for (WeightedEdge e : kruskal.getMst()) {
            sum += e.getW();
        }
        System.out.println(kruskal.getMst());
        System.out.println("cost of prims mst "+sum);
        Prims prims = new Prims(g);
        System.out.println(prims.getMst());
        sum = 0;
        for (WeightedEdge e : prims.getMst()) {
            sum += e.getW();
        }
        System.out.println("cost of prims mst "+sum);
    }
}
