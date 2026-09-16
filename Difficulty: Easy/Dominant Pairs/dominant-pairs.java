class Solution {
    public int dominantPairs(int[] arr) {
        // Code here
        int n = arr.length;
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);
        
        Arrays.sort(left);
        Arrays.sort(right);
        long count = 0;
        int i = 0;
        int j = 0;
        while(j < mid){
            while(i < mid && (long) left[i] < 5L * right[j]){
                i++;
            }
            count += mid - i;
            j++;
        }
        return (int) count;
    }
}