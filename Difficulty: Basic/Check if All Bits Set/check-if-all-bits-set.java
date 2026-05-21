class Solution {
    public boolean isBitSet(int n) {
        // code here
        if(n == 0) return false;
        while(n > 0){
            int bit = n & 1;
            if(bit == 0) return false;
            n = n >> 1;
        }
        return true;
    }
};