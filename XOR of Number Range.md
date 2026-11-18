## 01. XOR of Number Range

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/find-xor-of-numbers-from-l-to-r/1)

### Problem Description

**Task:** Given two integers l and r, find the bitwise XOR of all integers in the range [l, r] (both inclusive).Examples:Input: l = 4, r = 8

#### Examples

##### Example 1

- **Output:**
```text
5
```
- **Explanation:** The XOR of all integers from 5 to 9 is (5 xor 6 xor 7 xor 8 xor 9) = 5.Constraints:1 ≤ l ≤ r ≤ 10⁹

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(1)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-18 23:41:45
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int findXOR(int l, int r) {
        return xorUpto(r) ^ xorUpto(l - 1);
    }

    private int xorUpto(int n) {
        return switch (n & 3) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n + 1;
            default -> 0;
        };
    }
}
```

*Generated on: 11/18/2026, 11:42:14 PM*