package graph;
import java.util.*;

class rottenOranges {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Count fresh oranges and queue up initial rotten ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (freshCount == 0) return 0;

        int time = 0;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        freshCount--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) {
                time++;
            }
        }

        return freshCount == 0 ? time : -1;
    }
    public static void main(String[] args) {
        rottenOranges solution = new rottenOranges();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 2}
        };
        int result = solution.orangesRotting(grid);
        System.out.println("Time taken to rot all oranges: " + result); // Output: 4
    }
}