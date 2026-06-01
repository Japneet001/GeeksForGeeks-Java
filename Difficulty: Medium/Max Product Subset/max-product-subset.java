class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        if (n == 1)  return arr[0];

        long mod = 1000000007;
        long maxProduct = 1;
        
        int countZeros = 0;
        int countNegatives = 0;
        int maxNegative = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num == 0) {
                countZeros++;
                continue;
            }
            if (num < 0) {
                countNegatives++;
                maxNegative = Math.max(maxNegative, num);
            }
        }

        if (countZeros == n || (countNegatives == 1 && countZeros + countNegatives == n)) {
            return 0;
        }

        boolean skipped = false;
        for (int num : arr) {
            if (num == 0)  continue;
            
            if (countNegatives % 2 != 0 && num == maxNegative && !skipped) {
                skipped = true;
                continue;
            }
            
            maxProduct = (maxProduct * num) % mod;
        }

        if (maxProduct < 0)  maxProduct = (maxProduct + mod) % mod;
        
        return (int) maxProduct;
    }
}