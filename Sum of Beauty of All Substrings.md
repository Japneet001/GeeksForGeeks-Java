## 01. Sum of Beauty of All Substrings

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1)

### Problem Description

**Task:** Given a string s, return the sum of the beauty of all substrings of s. The beauty of a substring is defined as the difference between the maximum and minimum frequencies of the characters present in that substring.Examples:Input: s = "aaac"Output: 3Explanation: The substrings with non-zero beauty are "aaac" and "aac". For "aaac", the frequencies are a = 3 and c = 1. Its beauty is 3 − 1 = 2. For "aac", the frequencies are a = 2 and c = 1. Its beauty is 2 − 1 = 1. The remaining substrings have a beauty of 0. Therefore, the sum of the beauties of all substrings is 2 + 1 = 3.Input: s = "aabc"Output: 2Explanation: The substrings with non-zero beauty are "aab" and "aabc". For "aab", the frequencies are a = 2 and b = 1. Its beauty is 2 − 1 = 1. For "aabc", the frequencies are a = 2, b = 1, and c = 1. Its beauty is 2 − 1 = 1. Therefore, the sum of the beauties of all substrings is 1 + 1 = 2.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(|s| * |s|)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-25 22:58:17
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}
```

*Generated on: 10/25/2026, 10:58:47 PM*