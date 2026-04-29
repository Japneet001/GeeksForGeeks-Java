class Solution {
    public int minSwaps(int[] arr) {
        // code here
        int cnt0 = 0;
        int cnt1 = 0;
        int n = arr.length;
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(arr[i]==0) cnt0++;
            else cnt1++;
        }
        
        if(cnt1==0) return -1;
        if(cnt1==n) return 0;
        
        int i = 0;
        int j = cnt1-1;
        int k = 0;
        
        while(k<=j){
            if(arr[k]==1) ans++;
            k++;
        }
        
        k = ans;
        ans = (cnt1-k);
        j++;
        
        while(j<n){
            if(arr[j]==1) k++;
            if(arr[i]==1) k--;
            j++;
            i++;
            
            ans = Math.min(ans,cnt1-k);
        }
        
        return ans;
    }
}