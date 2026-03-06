class Solution {
    public static String minWindow(String s, String p) {
        // code here
        if(p.length()>s.length()) return "";
        int fre[]=new int[256];
        for(char c:p.toCharArray()){
            fre[c]++;
        }
        int l=0,c=p.length();
        int min=Integer.MAX_VALUE;
        int st=0;
        for(int i=0;i<s.length();i++){
            if(fre[s.charAt(i)]>0){
                c--;
            }
            fre[s.charAt(i)]--;
            while(c==0){
                if(i-l+1<min){
                    min=i-l+1;
                    st=l;
                }
                fre[s.charAt(l)]++;
                if(fre[s.charAt(l)]>0){
                    c++;
                }
                l++;
            }
        }
        if(min==Integer.MAX_VALUE) return "";
        return s.substring(st,st+min);
    }
}

