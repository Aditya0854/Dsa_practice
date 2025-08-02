import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int initialColor = image[sr][sc];

        int row = image.length;
        int col = image[0].length;

        if(initialColor == color) return image;

        queue.offer(new int[]{sr,sc});

        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            image[r][c] = color;

            for(int[] d: dir) {
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0 && nr<row && nc>=0 && nc<col && image[nr][nc] == initialColor){
                    image[nr][nc] = color;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }

        return image;
    }
}

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        Solution solution = floodFill.new Solution();
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;
        int[][] result = solution.floodFill(image, sr, sc, color);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
