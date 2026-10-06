## 01. Longest Increasing Path in Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1)

### Problem Description

**Task:** Given a matrix with n rows and m columns, find the length of the longest path such that:The path can start and end at any cell.A cell cannot be visited more than once.The values in path are strictly increasing. From each cell, you can move left, right, up, or down. Diagonal moves and moves outside the matrix are not allowed.Examples:Input: n = 3, m = 3, matrix[][] = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

#### Examples

##### Example 1

- **Output:**
```text
1
```
- **Explanation:** There can at most one vertex as all vertices are same.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(n * m)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-06 23:29:22
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    public int longIncPath(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, dfs(matrix, dp, i, j, n, m));
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] dp, int r, int c, int n, int m) {
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        int best = 1;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && matrix[nr][nc] > matrix[r][c]) {
                best = Math.max(best,
                        1 + dfs(matrix, dp, nr, nc, n, m));
            }
        }

        dp[r][c] = best;
        return best;
    }
}
```

*Generated on: 06/10/2026, 23:29:57*