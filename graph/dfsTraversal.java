import java.util.*;

public class dfsTraversal {
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls) {

        //marking current node as visited
        vis[node] = true;
        ls.add(node);

        //getting meighbors of current node
        for(Integer it: adj.get(node)) {
            if(vis[it] == false) {
                dfs(it, vis, adj, ls);
            }
        }

    }

    public ArrayList<Integer> dfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[v+1];
        vis[0] = true; // Assuming 0 is the starting node
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, vis, adj, ls);
        return ls;
    }
    public static void main(String[] args) {
        int v = 5; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        dfsTraversal obj = new dfsTraversal();
        ArrayList<Integer> result = obj.dfsGraph(v, adj);

        System.out.println("DFS Traversal: " + result);
    }
}
