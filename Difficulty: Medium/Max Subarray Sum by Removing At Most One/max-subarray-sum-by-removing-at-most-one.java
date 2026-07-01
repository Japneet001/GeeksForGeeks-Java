class Solution {
    public int maxSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        
        int n = arr.length;

        // Base case: for a single element, we cannot skip it as the subarray must remain non-empty.

        int maxEndNoSkipping = arr[0];
        int maxEndSkipping = arr[0];
        int overallMax = arr[0];

        for (int i = 1; i < n; i++) {

            // Order of assignment matters because maxEndSkipping depends on the previous maxEndNoSkipping value.

            maxEndSkipping = Math.max(maxEndNoSkipping, maxEndSkipping + arr[i]);
            maxEndNoSkipping = Math.max(arr[i], maxEndNoSkipping + arr[i]);

            // Track the maximum sum found so far
            overallMax = Math.max(overallMax, Math.max(maxEndNoSkipping, maxEndSkipping));
        }

        return overallMax;
    }
}