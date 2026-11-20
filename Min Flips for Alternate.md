## 01. Min Flips for Alternate

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/min-number-of-flips3210/1)

### Problem Description

**Task:** Given a binary string s, we can flip any bit (change 0 to 1 or 1 to 0) to make the string alternating. A string is called alternating if no two adjacent characters are the same. Find the minimum number of bit flips required to make the string alternating.Examples:Input: s = "001"

#### Examples

##### Example 1

- **Output:**
```text
1
```
- **Explanation:** Flip the bit at index 0 from 0 to 1 to obtain "101", which is an alternating binary string. Hence, the minimum number of flips required is 1.

##### Example 2

- **Input:**
```text
s = "0001010111"
```
- **Output:**
```text
2
```
- **Explanation:** Flip the bit at indices 1 and 8 to obtain "0101010101", which is an alternating binary string. Hence, the minimum number of flips required is 2.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-20 23:10:08
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int minFlips(String s) {
        // code here

        int n = s.length();
        int opr1 = 0 , opr2 = 0;
        char currChar1 = '0' , currChar2 = '1';

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(ch != currChar1) opr1++;
            if(ch != currChar2) opr2++;

            char tempChar = currChar1;
            currChar1 = currChar2;
            currChar2 = tempChar;
        }
        return Math.min(opr1 , opr2);
    }
}
```

*Generated on: 11/20/2026, 11:10:49 PM*