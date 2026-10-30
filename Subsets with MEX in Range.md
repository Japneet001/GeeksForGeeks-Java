## 01. Subsets with MEX in Range

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/crazy-subsets--131708/1)

### Problem Description

**Task:** Given an array arr[] of integers and a range [l, r], count the number of subsets whose Minimum Excluded (MEX) value lies within the given range, inclusive.Minimum Excluded (or MEX) of a subset is the smallest non-negative integer that is not present in the subset. An empty subset has Minimum Excluded as zero. Since the answer can be very large, return the answer modulo 10⁹ + 7.Examples:Input: arr[] = [2, 0, 1, 0], l = 1, r = 2

#### Examples

##### Example 1

- **Output:**
```text
9
```
- **Explanation:** The subsets whose MEX lies in the range [1, 2] are counted as follows:MEX = 1: The subsets must contain at least one 0 and must not contain 1. These subsets are [0] (2 ways), [2, 0] (2 ways), [0, 0] (1 way), and [2, 0, 0] (1 way). Total = 6.MEX = 2: The subsets must contain both 0 and 1 but must not contain 2. These subsets are [0, 1] (2 ways) and [0, 1, 0] (1 way). Total = 3.The subsets [2, 0, 1] and [2, 0, 1, 0] have MEX = 3, which is outside the given range. Therefore, the total number of valid subsets is 6 + 3 = 9.Input: arr[] = [2, 0, 1], l = 1, r = 2Output: 3Explanation: The subsets whose MEX lies in the range [1, 2] are [0] (MEX = 1), [2, 0] (MEX = 1), and [0, 1] (MEX = 2). Hence, the answer is 3.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + r)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-30 22:08:30
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    static final long MOD = 1000000007L;

    public int cntSubsets(int arr[], int l, int r) {
        // code here
        int n = arr.length;

                int[] freq = new int[n + 1];

                for (int x : arr) {
                    if (x <= n) {
                        freq[x]++;
                    }
                }

                // Precompute powers of 2
                long[] pow2 = new long[n + 1];
                pow2[0] = 1;

                for (int i = 1; i <= n; i++) {
                    pow2[i] = (pow2[i - 1] * 2) % MOD;
                }

                long ans = 0;
                long required = 1;
                int prefixFreq = 0;

                for (int k = 0; k <= r; k++) {

                    // Number k must be absent.
                    int greaterCount = n - prefixFreq - freq[k];

                    if (k >= l) {
                        long ways = (required * pow2[greaterCount]) % MOD;
                        ans = (ans + ways) % MOD;
                    }

                    // Every number from 0 to k must occur.
                    if (freq[k] == 0) {
                        break;
                    }

                    long choices = (pow2[freq[k]] - 1 + MOD) % MOD;

                    required = (required * choices) % MOD;
                    prefixFreq += freq[k];
                }

                return (int) ans;
    }
}
```

*Generated on: 10/30/2026, 10:09:02 PM*