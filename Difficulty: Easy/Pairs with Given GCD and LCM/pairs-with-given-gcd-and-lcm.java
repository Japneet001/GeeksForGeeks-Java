class Solution {
    public int pairCount(int x, int y) {
        // If y is not divisible by x, no such pair exists
        if (y % x != 0) return 0;

        int k = y / x;
        int distinctPrimeFactors = 0;

        // Count distinct prime factors
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                distinctPrimeFactors++;
                // Divide out all instances of this prime factor to shrink k
                while (k % i == 0) {
                    k /= i;
                }
            }
        }

        // If the remaining k is greater than 1, it is also a prime factor
        if (k > 1) {
            distinctPrimeFactors++;
        }

        // Total pairs = 2^distinctPrimeFactors
        return 1 << distinctPrimeFactors;
    }
}