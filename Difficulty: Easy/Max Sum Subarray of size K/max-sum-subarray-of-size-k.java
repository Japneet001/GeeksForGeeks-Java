class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        maxSum = sum;
        for(int i = 1; i < n - k + 1; i++){
            sum -= arr[i - 1];
            sum += arr[i + k - 1];
            maxSum = (maxSum < sum) ? sum : maxSum;
        }
        return maxSum;
    }
}