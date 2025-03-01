
public class WeightedUndirectedGraph {
    private final int V;
    private final Bag<WeightedEdge>[] adj;
    private int E;

    public WeightedUndirectedGraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(WeightedEdge e) {
        adj[e.getV1()].insert(e);
        adj[e.getV2()].insert(e);
        E++;
    }

    public void addEdge(int v1, int v2, double w) {
        WeightedEdge e = new WeightedEdge(v1, v2, w);
        addEdge(e);
    }

    public Iterable<WeightedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }


}
