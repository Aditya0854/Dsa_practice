package graph;

import java.util.*;

public class NoOfIslands {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
      List<List<Integer>> adj = new ArrayList<>();
      
      //crearting adjacency list 
      for(int i = 0; i< V;i++) {
        adj.add(new ArrayList<>());
      }

      for(List<Integer> edge: edges) {
        int u = edge.get(0);
        int v = edge.get(1);

        adj.get(u).add(v);
        adj.get(v).add(u);
      }

      boolean[] visited = new boolean[V];
      int components = 0;

      for(int i = 0; i< V; i++) {
        if(!visited[i]) {
          components++;
          dfs(i, visited, adj);
        }
      }

      return components;

    }

    public void dfs(int node, boolean[] visited,List<List<Integer>> adj){
      visited[node] = true;
      for(int neighbor: adj.get(node)) {
        if(!visited[neighbor]) {
          dfs(neighbor, visited, adj);
        }
      }
    }

    public static void main(String[] args) {
        // Create a test graph with 7 vertices (0 to 6) and multiple components
        int V = 7;
        List<List<Integer>> edges = new ArrayList<>();
        
        // Adding edges to create multiple components
        // Component 1: 0-1-2
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        
        // Component 2: 3-4
        edges.add(Arrays.asList(3, 4));
        
        // Component 3: 5-6
        edges.add(Arrays.asList(5, 6));

        NoOfIslands solution = new NoOfIslands();
        int numberOfComponents = solution.findNumberOfComponent(V, edges);
        
        System.out.println("Number of Connected Components (Islands): " + numberOfComponents);
        // Expected output: 3 components
    }
}
