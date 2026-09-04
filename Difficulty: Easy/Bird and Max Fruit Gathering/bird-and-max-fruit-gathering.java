class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here

        int  n = arr.size();
        int start = 0;
        int end = (m-1) % n;
        int sum = 0;
        int max = 0;

        while(start < m){
            sum+=arr.get(start++);
        }
        max = Math.max(max, sum);
        if(n == m){
            return max;
        }

        int temp = 0;

        while(start != end){
            sum-=arr.get(temp++);
            sum+=arr.get(start);
            max = Math.max(sum, max);
            start = (start + 1) % n;
        }

        return max;
    }
}