## 01. Balancing with Distinct Powers

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/balancing-pan5038/1)

### Problem Description

**Task:** Given a simple weighing scale with two pans, a target weight b, and a set of weights where each weight is a distinct power of a, find if the scale can be balanced such that: b + (some powers of a) = (some other powers of a)Note: Exactly one weight is available for each power of a, so each power can be used at most once.Examples:Input: a = 4, b = 11

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** 5 + 3 + 1 = 9. So, target = 5 can be balanced using powers of 3.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(log b)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-10 23:36:44
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public boolean balancePan(int a, int b) {
        // code here
        while (b > 0) {
            int r = b % a;

            if (r == 0) b = (int)Math.floor(b / a);
            else if (r == 1) b = (int)Math.floor((b - 1) / a);
            else if (r == a - 1) b = (int)Math.floor((b + 1) / a);
            else return false;
        }

        return true;
    }
}
```

*Generated on: 10/10/2026, 23:37:23*