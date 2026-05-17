class Solution {
    List<Integer> makeBeautiful(int[] arr) {
        // code here
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(!st.isEmpty()){
                int top = st.peek();
                if(top < 0){
                    if(arr[i] >= 0){
                        st.pop();
                        continue;
                    }
                }
                else{
                    if(arr[i] < 0){
                        st.pop();
                        continue;
                    }
                }
            }
            st.push(arr[i]);
        }
        
        while(!st.isEmpty()){
            ans.add(0, st.pop());
        }
        
        return ans;
    }
}