
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimsFast {
    private final WeightedUndirectedGraph g;
    private final boolean[] marked;
    private final IndexPQ<Double> pq;
    private final double[] distTo;
    WeightedEdge[] mst;


    public PrimsFast(WeightedUndirectedGraph g) {
        this.g = g;
        mst = new WeightedEdge[g.V()];
        marked = new boolean[g.V()];
        pq = new IndexPQ<>(g.V());
        distTo = new double[g.V()];
        Arrays.fill(distTo, Double.MAX_VALUE);
        distTo[0] = 0.0;
        pq.insert(0, distTo[0]);
        //System.out.println(pq);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            //System.out.println(pq);
            marked[v] = true;
            for (WeightedEdge e : g.adj(v)) {
                int w = e.getOther(v);
                if (marked[w]) continue;
                if (distTo[w] > e.getW()) {
                    distTo[w] = e.getW();
                    mst[w] = e;
                    if (pq.hasKey(w)) pq.decreaseKey(w, distTo[w]);
                    else pq.insert(w, distTo[w]);
                    //System.out.println(pq);
                }
            }
        }
    }

    public List<WeightedEdge> getMst() {
        System.out.println(Arrays.toString(mst));
        List<WeightedEdge> l = new ArrayList<>();
        for(WeightedEdge e : mst){
            if(e!=null)
                l.add(e);
        }
        return l;
    }

}
