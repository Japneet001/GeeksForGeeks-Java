## 01. Count Group Occurrences

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/count-the-characters1821/1)

### Problem Description

**Task:** Given a string s and an integer k, count the number of distinct characters that appear in exactly k groups in the string.A group is defined as one or more consecutive occurrences of the same character. For example, in the string "aaabbcca", the groups are "aaa", "bb", "cc" and "a".Examples:Input: s = "abc", k = 1Output: 3Explanation: The characters 'a', 'b' and 'c' each appear in exactly one group.Input: s = "geeksforgeeks", k = 2Output: 4Explanation: The characters 'g', 'e', 'k' and 's' each appear in exactly two groups.Input: s = "aaaaa", k = 2Output: 0Explanation: The character 'a' appears in only one group, so no character appears in exactly two groups.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-09 23:09:53
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    int getCount(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, n = s.length();

        while (i < n) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            int j = i + 1;
            while (j < n && s.charAt(j) == ch) {
                j++;
            }
            i = j;
        }

        int count = 0;
        for (int freq : map.values()) {
            if (freq == k) count++;
        }

        return count;
    }
}
```

*Generated on: 11/9/2026, 11:11:03 PM*