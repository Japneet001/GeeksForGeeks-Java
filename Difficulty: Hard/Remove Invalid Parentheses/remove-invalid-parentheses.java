class Solution {
    HashSet<String> set;
    List<String> result;
    String s;
    int n;
    
    private int minRemovals(){
        int count=0;
        
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(stack.isEmpty())count++;
                else stack.pop();
            }
            else if(ch=='('){
                stack.add('(');
            }
        }
        
        return count+stack.size();
    }
    
    private boolean isValid(String path){
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<path.length();i++){
            char ch=path.charAt(i);
            if(ch==')'){
                if(stack.isEmpty())return false;
                else stack.pop();
            }
            else if(ch=='('){
                stack.add('(');
            }
            
        }
        return stack.isEmpty();
    }
    private void solve(int i,String path,int minOp){
        if(i==n){
            if(minOp==0 && isValid(path)) set.add(path);
            return ;
        }
        
        if(minOp<0)return;
        
        if(s.charAt(i)==')' || s.charAt(i)=='('){
            solve(i+1,path,minOp-1);
            solve(i+1,path+s.charAt(i),minOp);
        }
        else{
            solve(i+1,path+s.charAt(i),minOp);
        }
    }
    public List<String> validParenthesis(String s) {
        // code here
        result=new ArrayList<>();
        set=new HashSet<>();
        n=s.length();
        this.s=s;
        
        int minOp=minRemovals();
        
        solve(0,"",minOp);
        
        for(String ss:set)result.add(ss);
        
        Collections.sort(result);
        if(result.isEmpty()){
            result.add("");
        }
        return result;
    }
}