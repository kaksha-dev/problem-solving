import java.util.Arrays;
import java.util.Stack;

public class BellmanFord {

    private final WeightedDirectedGraph g;
    private final double[] distTo;
    private final WeightedDirectedEdge[] edgeTo;


    public BellmanFord(WeightedDirectedGraph g) {
        this.g = g;
        this.distTo = new double[g.V()];
        edgeTo = new WeightedDirectedEdge[g.V()];

        Arrays.fill(this.distTo, Double.MAX_VALUE);
        distTo[0] = 0.0;
        int i = 0;
        for (; i < g.V() - 1; i++) {
            boolean hasModified = visitAllVertex();
            if (!hasModified) break; // break if in this iteration no changes made in any distance.
        }
        System.out.println("total iteration happened :" + i);
    }

    private boolean visitAllVertex() {
        boolean hasModified = false;
        for (int v = 0; v < g.V(); v++) {
            for (WeightedDirectedEdge e : g.adj(v)) {
                int w = e.getTo();
                if (distTo[w] > distTo[v] + e.getW()) {
                    distTo[w] = distTo[v] + e.getW();
                    edgeTo[w] = e;
                    hasModified = true;
                }
            }
        }
        return hasModified;
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
