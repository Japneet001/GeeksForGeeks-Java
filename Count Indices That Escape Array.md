## 01. Count Indices That Escape Array

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/good-stones--170647/1)

### Problem Description

**Task:** Given an array arr[], where arr[i] represents the exact number of steps to move from index i. An index is considered good if repeatedly following the jumps eventually takes you outside the array. Otherwise, if the jumps result in an infinite loop, the index is considered bad. A positive value indicates a move to the rightA negative value indicates a move to the left.A 0 value means no move and considered bad.Return the number of good indices.Examples:Input: [2, 3, -1, 2, -2, 4, 1]

#### Examples

##### Example 1

- **Output:**
```text
3
```
- **Explanation:** Indices 3, 5, and 6 are good because their jump sequences eventually leave the array. Indices 1, 2, and 4 form a cycle, while index 0 eventually enters this cycle through index 2. Hence, the total number of good indices is 3.

##### Example 2

- **Input:**
```text
[1, 0, -3, 0, -5, 0]
```
- **Output:**
```text
2
```
- **Explanation:** Indices 2 and 4 are good because their jumps take them outside the array. Indices 1, 3, and 5 are bad because their jumps are zero. Index 0 is also bad because it jumps to index 1, which is a dead end. Hence, the total number of good indices is 2.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-19 15:29:01
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public static int goodIndices(int[] arr) {
        int n = arr.length;
        int[] phase = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(phase[i] == 0) code(i, n, arr, phase);
            if(phase[i] == 2) ++cnt;
        }
        return cnt;
    }

    private static boolean code(int i, int n, int[] arr, int[] phase) {
        if(i < 0 || i >= n || phase[i] == 2) return true;
        if(phase[i] == 1) return false;

        phase[i] = 1;
        boolean cc = code(i+arr[i], n, arr, phase);

        if(cc) phase[i] = 2;
        return cc;
    }
}
```

*Generated on: 10/19/2026, 3:29:32 PM*