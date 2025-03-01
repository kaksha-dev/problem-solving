
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {
    private final WeightedUndirectedGraph g;
    private final boolean[] marked;
    private final PriorityQueue<WeightedEdge> pq;
    List<WeightedEdge> mst;

    public Prims(WeightedUndirectedGraph g) {
        this.g = g;
        mst = new ArrayList<>();
        marked = new boolean[g.V()];
        pq = new PriorityQueue<>();
        buildMST();
    }

    private void buildMST() {
        visit(0);
        while (!pq.isEmpty()) {
            if (mst.size() == g.V() - 1) break;
            WeightedEdge e = pq.poll();
            assert e != null;
            int v1 = e.getV1();
            int v2 = e.getV2();
            if (marked[v1] && marked[v2]) continue;
            mst.add(e);
            if (!marked[v1]) visit(v1);
            if (!marked[v2]) visit(v2);
        }
    }

    private void visit(int v) {
        for (WeightedEdge e : g.adj(v)) {
            pq.add(e);
        }
        marked[v] = true;
    }

    public List<WeightedEdge> getMst() {
        return mst;
    }
}
