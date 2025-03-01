
import java.util.Arrays;

public class Graph {
    private final int V;
    private final Bag<Integer>[] adj;
    private int E;

    public Graph(int V) {
        this.V = V;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].insert(w);
        adj[w].insert(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V +
                ", adj=" + Arrays.toString(adj) +
                ", E=" + E +
                '}';
    }
}
