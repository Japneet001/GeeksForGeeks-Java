class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int ans = 0;
        
        pre[0] = arr[0];
        suf[n - 1] = arr[n - 1];
        
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(arr[i], pre[i - 1]);
            suf[n - i - 1] = Math.max(arr[n - i - 1], suf[n - i]);
        }
        
        for(int i = 0; i < n; i++){
            ans += Math.min(pre[i], suf[i]) - arr[i];
        }

        return ans;
    }
}
