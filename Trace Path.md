## 01. Trace Path

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/trace-path3840/1)

### Problem Description

**Task:** Given a rectangular grid with n rows and m columns, and a string s representing a sequence of movement commands. Geek can start from any cell of the grid and follows all the commands in s in the same order.The string s consists only of the characters L, R, D, and U, where:L: Move one cell left, from (i, j) to (i, j - 1).R: Move one cell right, from (i, j) to (i, j + 1).D: Move one cell up, from (i, j) to (i - 1, j).U: Move one cell down, from (i, j) to (i + 1, j).Determine whether there exists at least one starting cell such that Geek remains within the grid while following all the commands in s.Examples:Input: n = 1, m = 1, s = "R"

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** One possible cell is (1, 3). (1, 3) - > (1, 2) - > (1, 1) - > (1, 2) - > (2, 2). Thus, there is a cell from where if Geek starts, it remains inside the grid throughout tracing the route.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(|s|)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-24 23:40:17
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public boolean isPossible(int n, int m, String s) {
        // code here
        int rowmin=0;
        int rowmax=0;
        int colmin=0;
        int colmax=0;

        int row=0;
        int col=0;

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='L')col--;
            else if(c=='R')col++;
            else if(c=='U')row--;
            else row++;

            rowmin=Math.min(rowmin,row);
            rowmax=Math.max(rowmax,row);
            colmin=Math.min(colmin,col);
            colmax=Math.max(colmax,col);
        }

        if(n>= rowmax-rowmin+1 && m>=colmax-colmin+1)return true;
        return false;
    }
}
```

*Generated on: 10/24/2026, 11:40:55 PM*