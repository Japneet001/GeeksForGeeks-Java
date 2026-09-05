class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        int[] dp = new int[1000001];
        int ans = 1;

        for(int x : arr){
            dp[x] = 1 + Math.max(dp[x-1], dp[x+1]);
            ans = Math.max(ans, dp[x]);
        }
        
        return ans;
    }
}
