## 01. Minimum Days

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimum-days--170646/1)

### Problem Description

**Task:** Given a string s of length n containing only lowercase English letters, and a permutation array p[] of length n containing integers from 0 to n - 1. On the (i + 1)th day, the character at index p[i] in the string is replaced with '?'. For example:On day 1, replace s[p[0]] with '?'.On day 2, replace s[p[1]] with '?'.On day 3, replace s[p[2]] with '?'.And so on.Find the minimum number of days required so that no two adjacent characters in s are equal, unless at least one of them is '?'.Formally, for every index i (0 <= i < n - 1), the string must satisfy: If s[i] ! = '?' and s[i+1] ! = '?', then s[i] ! = s[i+1].Examples:Input: s = "aabb", p = [2, 1, 3, 0]

#### Examples

##### Example 1

- **Output:**
```text
0 The initial string "abca" already satisfies the condition without replacing any characters.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n) [Note: For CPP - O(1)]

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-05 22:55:46
- **Status:** Correct
- **Marks:** 4

```java
public class Solution {
    public int getMinimumDays(String s, int[] p) {
        int n = s.length();

        // dayOfIndex[k] will store the day on which the character at index k is replaced by '?'
        int[] dayOfIndex = new int[n];
        for (int i = 0; i < n; i++) {
            dayOfIndex[p[i]] = i + 1;
        }

        int minDaysRequired = 0;

        // Scan the string for adjacent identical characters
        for (int j = 0; j < n - 1; j++) {
            if (s.charAt(j) == s.charAt(j + 1)) {
                // The pair is resolved when the first of the two characters is replaced
                int dayResolved = Math.min(dayOfIndex[j], dayOfIndex[j + 1]);

                // We need to wait until the last violation is resolved
                minDaysRequired = Math.max(minDaysRequired, dayResolved);
            }
        }

        return minDaysRequired;
    }
}
```

*Generated on: 11/5/2026, 10:56:23 PM*