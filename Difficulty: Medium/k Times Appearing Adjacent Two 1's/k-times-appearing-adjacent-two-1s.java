class Solution {
    public int countStrings(int n, int k) {
        // code here
        final int MOD = 1000000007;

        // Maximum possible adjacent "11" pairs is n-1
        if (k > n - 1)
            return 0;

        long[][] dp = new long[k + 1][2];

        dp[0][0] = 1; // "0"
        dp[0][1] = 1; // "1"

        for (int i = 2; i <= n; i++) {

            long[][] ndp = new long[k + 1][2];

            for (int j = 0; j <= k; j++) {
                ndp[j][0] = (ndp[j][0] + dp[j][0]) % MOD;
                ndp[j][0] = (ndp[j][0] + dp[j][1]) % MOD;
                ndp[j][1] = (ndp[j][1] + dp[j][0]) % MOD;
                if (j + 1 <= k) {
                    ndp[j + 1][1] = (ndp[j + 1][1] + dp[j][1]) % MOD;
                }
            }

            dp = ndp;
        }

        return (int) ((dp[k][0] + dp[k][1]) % MOD);
    }
}