package graph;
import java.util.*;
public class dfsUsingStack {
    public ArrayList<Integer> dfs(int v,ArrayList<ArrayList<Integer>> adj ) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start from the first node (0)

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(!visited[node]) {
                visited[node] = true;
                result.add(node);

                ArrayList<Integer> neighbors = adj.get(node);
                //Push newighbors in reverse for correct DFS order
                for(int i = neighbors.size() - 1; i>=0;i--) {
                    int neighbor = neighbors.get(i);
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
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

        dfsUsingStack obj = new dfsUsingStack();
        ArrayList<Integer> result = obj.dfs(v, adj);

        System.out.println("DFS Traversal using Stack: " + result);
    }
}
