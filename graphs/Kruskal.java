
import com.chitkara.disjointset.WeightedQUPCompression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    private final WeightedUndirectedGraph g;
    List<WeightedEdge> mst;

    public Kruskal(WeightedUndirectedGraph g) {
        this.g = g;
        mst = new ArrayList<>();
        buildMST();
    }

    private void buildMST() {
        List<WeightedEdge> edges = new ArrayList<>();  //Space = O(E)
        for (int i = 0; i < g.V(); i++) {
            for (WeightedEdge e : g.adj(i)) {
                edges.add(e);
            }
        }
        Collections.sort(edges);  // E log (E)

        WeightedQUPCompression uf = new WeightedQUPCompression(g.V());
        for (WeightedEdge edge : edges) {    //V-1
            if (mst.size() == g.V() - 1) break;
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            if (uf.find(v1, v2)) {
                continue;
            }
            uf.union(v1, v2);   // log*V
            mst.add(edge);
        }
    }

    public List<WeightedEdge> getMst() {
        return mst;
    }
}
