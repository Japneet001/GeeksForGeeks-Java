class Solution {
    boolean wifiRange(String S, int X) {

        int N = S.length();

        int[] diff = new int[N + 1];

        // Mark coverage ranges
        for (int i = 0; i < N; i++) {

            if (S.charAt(i) == '1') {

                int left = Math.max(0, i - X);
                int right = Math.min(N - 1, i + X);

                diff[left]++;

                if (right + 1 < N) {
                    diff[right + 1]--;
                }
            }
        }

        // Prefix sum to check coverage
        int coverage = 0;

        for (int i = 0; i < N; i++) {

            coverage += diff[i];

            if (coverage <= 0) {
                return false;
            }
        }

        return true;
    }
}