class Solution {
    String removeSpaces(String s) {
        // code here
        String ans = new String();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                ans = ans + s.charAt(i);
            }
        }
        
        return ans;
    }
}