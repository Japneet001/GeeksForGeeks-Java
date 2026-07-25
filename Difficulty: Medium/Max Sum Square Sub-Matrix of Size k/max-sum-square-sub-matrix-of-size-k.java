class Solution {
    public int maximumSum(int[][] mat, int k) {
         int n = mat.length;

        // Row-wise prefix sums
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                mat[i][j] += mat[i][j - 1];
            }
        }

        int maxSum = Integer.MIN_VALUE;

        // Try every possible top-left corner
        for (int row = 0; row <= n - k; row++) {
            for (int col = 0; col <= n - k; col++) {

                int currSum = 0;

                // Sum the k rows
                for (int r = row; r < row + k; r++) {
                    if (col == 0) {
                        currSum += mat[r][col + k - 1];
                    } else {
                        currSum += mat[r][col + k - 1] - mat[r][col - 1];
                    }
                }

                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}