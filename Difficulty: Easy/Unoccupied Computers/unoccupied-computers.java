class Solution {
    public int solve(int n, String s) {
        // code here
        boolean[] seen = new boolean[26];
        boolean[] using = new boolean[26];

        int available = n;
        int ans = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'A';

            if (!seen[idx]) {
                seen[idx] = true;

                if (available > 0) {
                    available--;
                    using[idx] = true;
                } else {
                    ans++;
                }
            } else {
                if (using[idx]) {
                    available++;
                    using[idx] = false;
                }
            }
        }

        return ans;
    }
}

