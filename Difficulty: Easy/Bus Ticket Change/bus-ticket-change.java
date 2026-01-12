class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int fives = 0;
        int tens = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 5){
                fives++;
            }
            else if(arr[i] == 10){
                tens++;
                if(fives == 0) return false;
                else fives--;
            }
            else{
                if(tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                }
                else if(tens == 0 && fives >= 3) {
                    fives-=3;
                }
                else if(fives == 0 || (tens == 0 && fives < 3)) {
                    return false;
                }
            }
        }
        return true;
    }
}