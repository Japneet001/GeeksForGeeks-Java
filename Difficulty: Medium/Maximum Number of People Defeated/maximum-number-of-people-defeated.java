class Solution {
    int maxPeopleDefeated(int p) {
        // code here
        int n = 0;
        int count = 0;
        for(int i = 1 ;i < Integer.MAX_VALUE;i++){
            n = i*i;
            if(p>=n){
                count++;
                p=p-n;
            }else{
                break;
            }
        }
        return count;
    }
};