class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        int[] ans = new int[n];
        ans[0] = arr[0] ^ arr[1];
        ans[n - 1] = arr[n - 2] ^ arr[n - 1];
        for(int i = 1; i < n - 1; i++){
            ans[i] = arr[i - 1] ^ arr[i + 1];
        }
        
        for(int i = 0; i < n; i++){
            arr[i] = ans[i];
        }
        
    }
}