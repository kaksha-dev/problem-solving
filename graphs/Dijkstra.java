import java.util.Arrays;
import java.util.Stack;

public class Dijkstra {

    private final WeightedDirectedGraph g;
    private final double[] distTo;
    private final IndexPQ<Double> pq;
    private final WeightedDirectedEdge[] edgeTo;


    public Dijkstra(WeightedDirectedGraph g) {
        this.g = g;
        this.distTo = new double[g.V()];
        pq = new IndexPQ<>(g.V());
        edgeTo = new WeightedDirectedEdge[g.V()];

        Arrays.fill(this.distTo, Double.MAX_VALUE);
        distTo[0] = 0.0;
        pq.insert(0, distTo[0]);
        //System.out.println(pq);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            //System.out.println(pq);
            visit(v);
        }
    }

    private void visit(int v) {
        for (WeightedDirectedEdge e : g.adj(v)) {
            int w = e.getTo();
            if (distTo[w] > distTo[v] + e.getW()) {
                distTo[w] = distTo[v] + e.getW();
                edgeTo[w] = e;
                if (pq.hasKey(w)) pq.decreaseKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
                //System.out.println(pq);
            }
        }
    }

    public boolean hasPath(int v) {
        return edgeTo[v] != null;
    }

    public Stack<WeightedDirectedEdge> pathTo(int v) {
        Stack<WeightedDirectedEdge> s = new Stack<>();
        for (WeightedDirectedEdge e = edgeTo[v]; e != null; ) {
            s.push(e);
            e = edgeTo[e.getFrom()];
        }
        return s;
    }

    public WeightedDirectedEdge[] getEdgeTo() {
        return this.edgeTo;
    }

    public double costTo(int v) {
        double cost = 0.0;
        for (WeightedDirectedEdge e : pathTo(v)) {
            cost += e.getW();
        }
        return cost;
    }
}
