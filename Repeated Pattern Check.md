## 01. Repeated Pattern Check

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/the-pattern-matcher/1)

### Problem Description

**Task:** Given a string s made of two characters of 'x' and 'y'. The task is to verify whether s is made by concatenating substrings that follow the pattern x^ny^n (equal number of y's follow equal number of x's).Examples:Input: s = "xxyyxy" Output: trueExplanation: The string can be split into "xxyy" + "xy". Both substrings contain an equal number of consecutive 'x' and 'y' characters.Input: s = "xyx"Output: falseExplanation: The last 'x' cannot form a valid substring because it is not followed by a matching 'y'.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(|s|)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-17 22:00:07
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public boolean findPattern(String s) {

        int i = 0;
        int n = s.length();

        while (i < n) {

            int xCount = 0;
            int yCount = 0;

            // Count consecutive x's
            while (i < n && s.charAt(i) == 'x') {
                xCount++;
                i++;
            }

            // There must be at least one x
            if (xCount == 0) {
                return false;
            }

            // Count consecutive y's
            while (i < n && s.charAt(i) == 'y') {
                yCount++;
                i++;
            }

            // Both counts must be equal
            if (xCount != yCount) {
                return false;
            }
        }

        return true;
    }
}
```

*Generated on: 11/17/2026, 10:00:41 PM*