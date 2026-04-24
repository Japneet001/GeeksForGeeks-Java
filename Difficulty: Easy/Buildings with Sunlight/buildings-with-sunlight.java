class Solution {
    public int visibleBuildings(int arr[]) {
        // code here
        int n = arr.length;
        int ans = 1;
        int[] pre = new int[n];
        
        pre[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i - 1], arr[i]);
            if(pre[i] <= arr[i]) ans++;
        }

        return ans;
    }
}