class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        if (arr.length == 1) return;
        int insertPos = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                if(i != insertPos){
                    arr[insertPos] = arr[insertPos] + arr[i];
                    arr[i] = arr[insertPos] - arr[i];
                }
                insertPos++;
            }
        }
    }
}