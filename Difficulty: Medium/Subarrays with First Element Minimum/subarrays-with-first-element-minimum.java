class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int ans=0,n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            int last=st.isEmpty()==true?n:st.peek();
            ans+=(last-i);
            st.push(i);
        }
        return ans;
    }
}