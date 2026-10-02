## 01. Lexicographically Smallest Rotation

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/lexicographically-smallest-string--151951/1)

### Problem Description

**Task:** Given a string s, find the lexicographically smallest string after rotating the string left any number of times including 0.Example:Input: s = "abcd"Output: "abcd"Explanation: String after each rotation are "abcd", "bcda", "cdab", "dabc" and so on. Lexicographically smallest among them is "abcd".Input: s = "baca"

#### Examples

##### Example 1

- **Output:**
```text
"abac"
```
- **Explanation:** Strings after each rotation are "baca", "acab", "caba", "abac" and so on. Lexicographically smallest among them is "abac".

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-02 06:29:07
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    public String lexiString(String s) {
        int n = s.length();
        int i = 0, j = 1, k = 0;

        // Two-pointer minimum rotation algorithm
        while (i < n && j < n && k < n) {
            char charI = s.charAt((i + k) % n);
            char charJ = s.charAt((j + k) % n);

            if (charI == charJ) {
                k++;
            } else {
                if (charI > charJ) {
                    i += k + 1;
                } else {
                    j += k + 1;
                }
                
                // Keep the pointers distinct
                if (i == j) {
                    j++;
                }
                k = 0; // Reset matching prefix length
            }
        }

        // The smaller index marks the beginning of the optimal rotation
        int startPos = Math.min(i, j);
        
        // Reconstruct and return the rotated string
        return s.substring(startPos) + s.substring(0, startPos);
    }
}
```

*Generated on: 02/10/2026, 06:29:42*