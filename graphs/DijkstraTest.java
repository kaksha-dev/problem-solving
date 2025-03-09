import java.util.Arrays;

public class DijkstraTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3(); //could not find any example where Dijkstra is failing, this one passes too.
    }

    private static void test1() {
        WeightedDirectedGraph g = new WeightedDirectedGraph(8);
        g.addEdge(new WeightedDirectedEdge(0, 1, 5.0));
        g.addEdge(new WeightedDirectedEdge(0, 7, 8.0));
        g.addEdge(new WeightedDirectedEdge(0, 4, 9.0));
        g.addEdge(new WeightedDirectedEdge(1, 7, 4.0));
        g.addEdge(new WeightedDirectedEdge(1, 2, 12.0));
        g.addEdge(new WeightedDirectedEdge(1, 3, 15.0));
        g.addEdge(new WeightedDirectedEdge(2, 3, 3.0));
        g.addEdge(new WeightedDirectedEdge(2, 6, 11.0));
        g.addEdge(new WeightedDirectedEdge(3, 6, 9.0));
        g.addEdge(new WeightedDirectedEdge(4, 7, 5.0));
        g.addEdge(new WeightedDirectedEdge(4, 5, 4.0));
        g.addEdge(new WeightedDirectedEdge(4, 6, 20.0));
        g.addEdge(new WeightedDirectedEdge(5, 2, 1.0));
        g.addEdge(new WeightedDirectedEdge(5, 6, 13.0));
        g.addEdge(new WeightedDirectedEdge(7, 5, 6.0));
        g.addEdge(new WeightedDirectedEdge(7, 2, 7.0));
        testBellmanAndDijkstra(g);
    }

    private static void test2() {
        WeightedDirectedGraph g = new WeightedDirectedGraph(7);
        g.addEdge(new WeightedDirectedEdge(0, 1, 6.0));
        g.addEdge(new WeightedDirectedEdge(0, 2, 5.0));
        g.addEdge(new WeightedDirectedEdge(0, 3, 5.0));
        g.addEdge(new WeightedDirectedEdge(1, 4, -1.0));
        g.addEdge(new WeightedDirectedEdge(2, 4, 1.0));
        g.addEdge(new WeightedDirectedEdge(2, 1, -2.0));
        g.addEdge(new WeightedDirectedEdge(3, 2, -2.0));
        g.addEdge(new WeightedDirectedEdge(3, 5, -1.0));
        g.addEdge(new WeightedDirectedEdge(5, 6, 3.0));
        g.addEdge(new WeightedDirectedEdge(4, 6, 3.0));
        testBellmanAndDijkstra(g);
    }

    private static void test3() {
        WeightedDirectedGraph g = new WeightedDirectedGraph(4);
        g.addEdge(new WeightedDirectedEdge(0, 1, 4.0));
        g.addEdge(new WeightedDirectedEdge(1, 2, 6.0));
        g.addEdge(new WeightedDirectedEdge(0, 3, 2.0));
        g.addEdge(new WeightedDirectedEdge(2, 3, -9.0));
        testBellmanAndDijkstra(g);
    }

    private static void testBellmanAndDijkstra(WeightedDirectedGraph g) {
        Dijkstra dijkstra = new Dijkstra(g);
        System.out.println(Arrays.toString(dijkstra.getEdgeTo()));
        BellmanFord bellmanFord = new BellmanFord(g);
        System.out.println(Arrays.toString(bellmanFord.getEdgeTo()));
        for (int i = 0; i < g.V(); i++) {
            assert bellmanFord.hasPath(i) == dijkstra.hasPath(i);
            assert bellmanFord.pathTo(i).size() == dijkstra.pathTo(i).size();
            assert bellmanFord.costTo(i) == dijkstra.costTo(i) : String.format("failed for vertex %d, bellman:%s while dijkstra:%s ", i, bellmanFord.costTo(i), dijkstra.costTo(i));
        }
    }
}
