class Solution {
    public int findPosition(int n) {
        // code here
        int count = 0;
        int pos = 0;
        
        while(n > 0){
            int bit = n & 1;
            if(bit == 1){
                count++;
            }
            pos++;
            if(count > 1) return -1;
            n = n >> 1;
        }
        
        return pos;
    }
}