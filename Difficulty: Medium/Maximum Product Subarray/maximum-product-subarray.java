class Solution {
    int maxProduct(int[] arr) {

        int res = arr[0], maxEnding = arr[0], minEnding = arr[0];
        
        for(int end = 1;end < arr.length;end++){
            int temp = maxEnding;
            maxEnding = Math.max(Math.max(maxEnding * arr[end], minEnding * arr[end]), arr[end]);
            minEnding = Math.min(Math.min(temp * arr[end], minEnding * arr[end]), arr[end]);
            res = Math.max(res, maxEnding);
        }
        
        return res;
    }
}