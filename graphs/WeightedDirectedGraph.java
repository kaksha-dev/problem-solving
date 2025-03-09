
public class WeightedDirectedGraph {
    private final int V;
    private final Bag<WeightedDirectedEdge>[] adj;
    private int E;

    public WeightedDirectedGraph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(WeightedDirectedEdge e) {
        adj[e.getFrom()].insert(e);
        E++;
    }

    public Iterable<WeightedDirectedEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }
}
