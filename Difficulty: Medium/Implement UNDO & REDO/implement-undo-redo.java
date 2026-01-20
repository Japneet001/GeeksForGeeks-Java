class Solution {
    Stack<Character> st = new Stack<>();
    Stack<Character> lastAppendedChar = new Stack<>();
    
    public void append(char x) {
        // append x into document
        st.push(x);
    }

    public void undo() {
        // undo last change
        lastAppendedChar.push(st.pop());
    }

    public void redo() {
        // redo changes
        st.push(lastAppendedChar.pop());
    }

    public String read() {
        // read the document
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.insert(0, st.pop());
        }
        for(int i = 0 ; i < ans.length(); i++){
            append(ans.charAt(i));
        }
        
        return ans.toString();
    }
}
