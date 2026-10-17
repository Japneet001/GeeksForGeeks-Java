## 01. Convert One String to Another with Constraints

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/check-if-it-is-possible-to-convert-one-string-into-another-with-given-constraints4116/1)

### Problem Description

**Task:** Given two strings s1 and s2, consisting only of the characters 'A', 'B', and '#'. Determine whether s1 can be transformed into s2 by performing the following operations on s1:'A' can move only towards the left. 'B' can move only towards the right.Neither 'A' nor 'B' can cross each other.'#' represents an empty position through which 'A' and 'B' can move.Moving the character at index i one step to the left means swapping it with the character at index i - 1, provided i - 1 >= 0. Similarly, moving it one step to the right means swapping it with the character at index i + 1, provided i + 1 < s1.length().Return true if s1 can be transformed into s2; otherwise, return false.Examples:Input: s1 = #A#B#B#, s2 = A###B#B

#### Examples

##### Example 1

- **Output:**
```text
false
```
- **Explanation:** The character 'A' in s1 is at index 1, whereas the corresponding 'A' in s2 is at index 3. Since 'A' can move only towards the left, it cannot reach a position to the right of its current position. Therefore, s1 cannot be transformed into s2, and hence, the answer is false.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + m)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-17 22:34:05
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public boolean isItPossible(String s1, String s2) {
        // code here
        if(s1.length() != s2.length())
            return false;
        int len = s1.length();
        int countA = 0;
        int countB = 0;
        for(int i=0;i<len;i++)
        {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == 'A')
                countA ++;
            else if(ch1 == 'B')
                countB++;

            if(ch2 == 'A')
                countA --;
            else if(ch2 == 'B')
                countB--;
            // s1 has more A till now
            if(countA>0)
                return false;
            if(countB<0)
                return false;
            if(countB>0 && countA<0)
                return false;

        }
        return true;
    }
};
```

*Generated on: 10/17/2026, 10:44:54 PM*