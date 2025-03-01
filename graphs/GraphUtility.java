
public class GraphUtility {

    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int i : g.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph g) {
        int max = 0;
        for (int i = 0; i < g.V(); i++) {
            max = Math.max(max, degree(g, i));
        }
        return max;
    }

    public boolean hasDirectPath(Graph g, int v, int w){
        for (int i : g.adj(v)) {
            if(i == w) return true;
        }
        return false;
    }
}
