class Solution {
    int maxSubstring(String s) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (char ch : s.toCharArray()) {
            int val = (ch == '0') ? 1 : -1;

            currSum = Math.max(val, currSum + val);
            maxSum = Math.max(maxSum, currSum);
        }

        return (maxSum <= 0) ? -1 : maxSum;
    }
}