class Solution {
    public static int solve(String s1 , String s2 , int i , int j , int[][] dp , int mod){
        if(j == s2.length()){
            return 1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int count = 0;
        
        if(i < s1.length()){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(j);
            
            if(ch1 == ch2){
                count = (count + solve(s1 , s2 , i + 1 , j + 1 , dp , mod)) % mod;
                count = (count + solve(s1 , s2 , i + 1 , j , dp , mod)) % mod;
            }else{
                count = (count + solve(s1 , s2 , i + 1 , j , dp , mod)) % mod;
            }
        }
        return dp[i][j] = count;
    }
    public static int countWays(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i] , -1);
        }
        int mod = (int)1e9 + 7;
        return solve(s1 , s2 , 0 , 0 , dp , mod);
    }
}