class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int n = q.size();
        Integer[] arr = q.toArray(new Integer[0]);
        q.removeAll(q);
        for(int i=0; i<n/2; i++){
            q.add(arr[i]);
            q.add(arr[i+n/2]);
        }
    }
}
