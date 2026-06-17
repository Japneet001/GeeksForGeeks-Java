class Solution {
    public int maxProduct(int n) {
        // code here
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int rem=n%3;
        if(rem==0){
            return (int) Math.pow(3,(n/3));
        }
        else if(rem==1){
            return (int) Math.pow(3,(n/3)-1)*4;
        }
        return (int) Math.pow(3,(n/3))*2;
    }
}