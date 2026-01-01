class Solution {
    public void sort012(int[] arr) {
        // code here
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) count0++;
            else if(arr[i] == 1) count1++;
            else count2++;
        }
        for(int i = 0; i < arr.length; i++){
            if(count0 == 0 && count1 == 0){
                arr[i] = 2;
                count2--;
            }
            else if(count0 == 0){
                arr[i] = 1;
                count1--;
            }
            else{
                arr[i] = 0;
                count0--;
            }
        }
    }
}