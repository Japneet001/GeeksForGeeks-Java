## 01. Sum of All Digit Subsequences

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1)

### Problem Description

**Task:** Given a string s which consists of digits, find sum of all digits across all non-empty subsequences of s.Note: Since the answer can be very large, return it modulo 10⁹ + 7.Examples:Input: s = "123"

#### Examples

##### Example 1

- **Output:**
```text
24
```
- **Explanation:** The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]. The sum of all digits in these subsequences is: 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) + (1 + 2 + 3) = 24.

##### Example 2

- **Input:**
```text
s = "405"
```
- **Output:**
```text
36
```
- **Explanation:** The non-empty subsequences are: [4], [0], [5], [4, 0], [4, 5], [0, 5], [4, 0, 5]. The sum of all digits in these subsequences is 36.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(|s|)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-15 23:29:28
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int subsequenceSum(String s) {
        final int MOD = 1000000007;
        long ds = 0;
        int n = s.length();
        for (char ch : s.toCharArray())
            ds = (ds + ch - '0') % MOD;
        long df = 1;
        for (int i = 1; i < n; i++)
            df = (df * 2) % MOD;
        return (int)((ds * df) % MOD);
    }
}
```

*Generated on: 11/15/2026, 11:30:56 PM*