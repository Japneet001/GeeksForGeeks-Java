class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        int q = queries.length;
        
        int[] pre = new int[n];
        pre[0] = arr[0];
        for(int i = 1; i < n; i++){
            pre[i] = pre[i - 1] + arr[i];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < q; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int num = pre[end] - pre[start] + arr[start];
            int dem = end - start + 1;
            
            ans.add(num / dem);
        }
        
        return ans;
    }
}