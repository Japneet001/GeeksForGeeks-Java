class Solution {
    private int findMax(ArrayList<Integer> temp, int k){
        int maximum = temp.get(0);
        for(int i = 1; i < k; i++){
            maximum = Math.max(maximum, temp.get(i));
        }
        return maximum;
    }
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>(k);
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < k; i++){
            temp.add(arr[i]);
            maximum = Math.max(maximum, arr[i]);
        }
        ans.add(maximum);
        for(int i = 1; i < n - k + 1; i++){
            temp.remove(0);
            temp.add(arr[i + k - 1]);
            if(maximum == arr[i - 1]){
                maximum = findMax(temp, k);
            }
            else{
                maximum = Math.max(maximum, arr[i + k - 1]);
            }
            ans.add(maximum);
        }
        return ans;
    }
}