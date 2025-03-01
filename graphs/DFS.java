
import java.util.Stack;

public class DFS {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    public DFS(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public boolean isConnected(int v) {
        return marked[v];
    }

    public void printPathTo(int v) {
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        while(!path.isEmpty()){
            System.out.print(path.pop() +" -> ");
        }
        System.out.println();
    }
}
