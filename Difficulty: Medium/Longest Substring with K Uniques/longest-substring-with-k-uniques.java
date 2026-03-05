class Solution {
     public int longestKSubstr(String s, int k) {
        // code here
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        int leftPointer=0;
        int maxLength=Integer.MIN_VALUE;
        for(int rightPointer=0;rightPointer<s.length();rightPointer++){
            char c=s.charAt(rightPointer);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(hm.size()>k){
                char ch=s.charAt(leftPointer);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)==0){
                    hm.remove(ch);
                }
                leftPointer++;
            }
            if(hm.size()==k){
                maxLength=Math.max(maxLength,Math.abs(rightPointer-leftPointer)+1);
            }
        }
        return maxLength==Integer.MIN_VALUE?-1:maxLength;
    }
}