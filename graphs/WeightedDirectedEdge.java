
public class WeightedDirectedEdge implements Comparable<WeightedDirectedEdge> {
    private final int from;
    private final int to;
    private final Double w;

    public WeightedDirectedEdge(int from, int to, double w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }

    @Override
    public int compareTo(WeightedDirectedEdge o) {
        return this.w.compareTo(o.w);
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public Double getW() {
        return w;
    }

    @Override
    public String toString() {
        return from + "-" + to + "(" + w + ')';
    }
}
