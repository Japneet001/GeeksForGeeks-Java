class Solution {
    
    public static void solve(int prevDigit , int currDigitCnt , int n , StringBuilder sb , ArrayList<Integer> result){
        if(currDigitCnt == n){
            result.add(Integer.parseInt(sb.toString()));
            return;
        }
        
        for(int i = prevDigit + 1 ; i <= 9 ; i++){
            sb.append(i);
            solve(i , currDigitCnt + 1, n , sb , result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static ArrayList<Integer> increasingNumbers(int n) {
        // code here
        
        ArrayList<Integer> result = new ArrayList<>();
        if(n > 9){
            return result;
        }
    
        if(n == 1){
            result.add(0);
        }
        
        StringBuilder sb = new StringBuilder("");
        
        solve(0 , 0 , n , sb , result);
        return result;
        
    }
}