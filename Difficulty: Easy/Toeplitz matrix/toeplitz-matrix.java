class Solution {
    public boolean isToeplitz(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 1; j++){
                if(mat[i][j] != mat[i + 1][j + 1]) return false;
            }
        }
        
        return true;
    }
}