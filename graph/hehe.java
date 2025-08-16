package graph;
import java.util.*;

public class hehe {
    public ArrayList<Integer> dfs(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> result  = new ArrayList<>();
        boolean[] visited = new boolean[v];
        Stack<Integer> stack  = new Stack<>();

        stack.push(0);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            
            if(!visited[node]) {
                visited[node] = true;
                result.add(node);

                ArrayList<Integer> neighbors = adj.get(node);

                for(int i = neighbors.size()-1; i>=0;i--) {
                    int neighbor = neighbors.get(i);
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }
}
