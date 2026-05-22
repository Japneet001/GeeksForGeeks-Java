class Solution {
    int n, m;
    int cntOnes(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        // Traverse first & last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0);

            if (grid[i][m - 1] == 1)
                dfs(grid, i, m - 1);
        }

        // Traverse first & last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1)
                dfs(grid, 0, j);

            if (grid[n - 1][j] == 1)
                dfs(grid, n - 1, j);
        }

        // Count remaining 1s
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int r, int c) {

        // Boundary check
        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != 1)
            return;

        // Mark visited
        grid[r][c] = -1;

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}