## 01. Nth in Concatenated Decimal String

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/nth-character-in-concatenated-decimal-string0245/1)

### Problem Description

**Task:** Consider a string s formed by concatenating the decimal representations of all positive integers in order:s = "12345678910111213141516171819202122232425262728293031..."Given an integer n, find the nth character (1-based indexing) in the string s.Examples:Input: n = 10

#### Examples

##### Example 1

- **Output:**
```text
'0'
```
- **Explanation:** The 11th character in "12345678910.." is '0'.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(log n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-28 22:56:25
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public char nthCharacter(int n) {
        long target = n; 
        long len = 1;    
        long count = 9;  
        long start = 1; 

        while (target > len * count) {
            target -= len * count;
            len++;               
            count *= 10;
            start *= 10;
        }
        long num = start + (target - 1) / len;
        String s = Long.toString(num);
        int index = (int) ((target - 1) % len);
        return s.charAt(index);
    }
}
```

*Generated on: 10/28/2026, 10:57:02 PM*