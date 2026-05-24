class Solution {
    public int coin(int[] arr) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = n - 1;
        while(s < e){
            if(arr[s] > arr[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return arr[s];
    }
}