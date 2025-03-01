
public class WeightedEdge implements Comparable<WeightedEdge> {
    private final int v1;
    private final int v2;
    private final Double w;

    public WeightedEdge(int v1, int v2, double w) {
        this.v1 = v1;
        this.v2 = v2;
        this.w = w;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        return this.w.compareTo(o.w);
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public Double getW() {
        return w;
    }

    @Override
    public String toString() {
        return v1 + "-" + v2 + "(" + w + ')';
    }
}
