class Solution {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int xor = 0;
        int maxXor = 0;
        for(int i = 0; i < k; i++){
            xor ^= arr[i];
        }
        maxXor = xor;
        for(int i = 1; i < n - k + 1; i++){
            xor ^= arr[i - 1];
            xor ^= arr[i + k - 1];
            maxXor = (xor > maxXor) ? xor : maxXor;
        }
        return maxXor;
    }
}
