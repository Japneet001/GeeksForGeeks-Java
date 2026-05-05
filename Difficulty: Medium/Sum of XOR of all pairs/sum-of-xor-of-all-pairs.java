class Solution {
    public long sumXOR(int[] arr) {
        int n = arr.length;
        long ans = 0;

        for(int bit = 0; bit < 32; bit++){
            long count1 = 0;

            for(int i = 0; i < n; i++){
                if((arr[i] & (1 << bit)) != 0){
                    count1++;
                }
            }

            long count0 = n - count1;
            ans += count1 * count0 * (1L << bit);
        }

        return ans;
    }
}