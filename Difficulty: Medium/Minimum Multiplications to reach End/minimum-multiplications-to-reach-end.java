class Solution {
    public int minSteps(int[] arr, int start, int end) {
        
        if(start==end) return 0;
        
        int[]dist=new int[1000];
        Arrays.fill(dist,-1);

        Queue<Integer>q=new ArrayDeque<>();
        dist[start]=0;
        q.offer(start);

        while(!q.isEmpty()){
            int node=q.poll();
            for(int it:arr){
                int next=(node*it)%1000;
                if(dist[next]==-1){
                    dist[next]=dist[node]+1;
                    if(next==end) return dist[next];
                    q.offer(next);
                }
            }
        }

        return-1;
    }

}

