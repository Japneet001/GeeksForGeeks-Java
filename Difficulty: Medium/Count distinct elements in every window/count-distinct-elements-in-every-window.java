class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ans.add(map.size());
        for(int i = 1; i < arr.length - k + 1; i++){
            map.put(arr[i - 1], map.get(arr[i - 1]) - 1);
            if(map.get(arr[i - 1]) == 0){
                map.remove(arr[i - 1]);
            }
            map.put(arr[i + k - 1], map.getOrDefault(arr[i + k - 1], 0) + 1);
            ans.add(map.size());
        }
        return ans;
    }
}