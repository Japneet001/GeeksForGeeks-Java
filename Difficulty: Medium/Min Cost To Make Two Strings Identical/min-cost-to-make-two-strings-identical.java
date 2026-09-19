class Solution {
    private int f(int[][] dp,String s1,String s2,int i,int j,int c1,int c2){
        int n = s1.length();
        int m = s2.length();
        if(i >= n){
            if(j >= m) return 0;
            else return c2 * (m - j);
        }
        if(j >= m){
            if(i >= n) return 0;
            else return c1 * (n - i);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int) 1e9;
        if(s1.charAt(i) == s2.charAt(j)) {
            return min = Math.min(min, f(dp, s1, s2, i+1, j+1, c1, c2));
        }
        else{
            int cost1 = c1 + f(dp, s1, s2, i+1, j, c1, c2);
            int cost2 = c2 + f(dp, s1, s2, i, j+1, c1, c2);
            min = Math.min(min, Math.min(cost1, cost2));
        }
        return dp[i][j] = min;
    }
    
    public int findMinCost(String s1, String s2, int c1, int c2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return f(dp, s1, s2, 0, 0, c1, c2);
    }
}