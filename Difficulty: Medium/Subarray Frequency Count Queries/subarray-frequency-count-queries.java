class Solution {
    
    public int findGreaterOrEqual(ArrayList<Integer> idxList , int lIdx){
        int left = 0;
        int right = idxList.size() - 1;
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(idxList.get(mid) >= lIdx){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    
    public int findLessOrEqual(ArrayList<Integer> idxList , int rIdx){
        int left = 0;
        int right = idxList.size() - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(idxList.get(mid) <= rIdx){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
        
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = arr.length;
        
        for(int i = 0 ; i < n ; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i] , new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int[] query : queries){
            int lIdx = query[0];
            int rIdx = query[1];
            int val = query[2];
            
            if(!map.containsKey(val)){
                result.add(0);
                continue;
            }else{
                ArrayList<Integer> idxList = map.get(val);
            
                int leftValidIdx = findGreaterOrEqual(idxList , lIdx);
                int rightValidIdx = findLessOrEqual(idxList , rIdx);
                
                if(leftValidIdx == -1 || rightValidIdx == -1){
                    result.add(0);
                    continue;
                }
                
                result.add(rightValidIdx - leftValidIdx + 1);
            }
            
        }
        return result;
    }
    
}