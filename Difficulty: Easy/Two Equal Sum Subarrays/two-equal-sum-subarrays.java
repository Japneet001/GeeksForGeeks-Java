class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        int preSum = 0;
        
        for(int i = 0; i < n; i++){
            totalSum += arr[i];
        }
        
        if(totalSum % 2 != 0) return false;
        
        int findSum = totalSum / 2;
        
        for(int i = 0; i < n; i++){
            preSum += arr[i];
            if(preSum == findSum) return true;
        }
        
        return false;
    }
}