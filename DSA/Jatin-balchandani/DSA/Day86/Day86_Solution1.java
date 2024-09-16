public class Day86_Solution1 {
    //DFS simmilair to surrounded by region https://leetcode.com/problems/surrounded-regions/
        public int numEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];

            // Traverse boundary elements and mark connected land cells
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 1) {
                        dfs(grid, vis, i, j);
                    }
                }
            }

            int cnt = 0;
            // Count unvisited land cells
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1 && vis[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        public void dfs(int[][] grid, int[][] vis, int row, int col) {
            int n = grid.length;
            int m = grid[0].length;
            int[] delrow = {-1, 0, 1, 0};
            int[] delcol = {0, 1, 0, -1};

            vis[row][col] = 1; // Mark cell as visited

            // Traverse in all four directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // Check for valid coordinates and unvisited land cell
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    dfs(grid, vis, nrow, ncol);
                }
            }
        }

}
