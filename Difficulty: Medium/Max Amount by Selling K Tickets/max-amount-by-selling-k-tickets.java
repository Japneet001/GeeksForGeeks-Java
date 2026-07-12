class Solution {
    public int maxAmount(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr)    pq.add(i);
        int mod=1000000007;long ans=0;
        while(k>0){
            int q=pq.poll();
            if(q<=0)    break;
            ans=(ans+q)%mod;
            k--;
            pq.add(q-1);
        }
        return (int) ans;
    }
}