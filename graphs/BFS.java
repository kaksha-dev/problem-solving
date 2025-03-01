
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    public BFS(Graph g, int s) {
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        bfs(g,s);
    }

    private void bfs(Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int w : g.adj(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
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
