class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int l = 0, r, count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(r = 0; r<arr.length; r++){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            while(map.size()>k){
                map.put(arr[l], map.get(arr[l])-1);
                
                if(map.get(arr[l]) == 0){
                    map.remove(arr[l]);
                }
                
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
}
