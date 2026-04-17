class Solution {
    boolean canFormPalindrome(String s) {
        // code here
        HashMap<Character, Integer> freq = new HashMap<>();
        int oddCount = 0;
        
        for(int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int val: freq.values()){
            if(val % 2 != 0) oddCount++;
        }
        
        return (oddCount <= 1);
    }
}