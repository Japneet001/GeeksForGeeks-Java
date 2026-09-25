## 01. Box Stacking

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/box-stacking/1)

### Problem Description

**Task:** Given three arrays height[], width[], and length[] of size n, where height[i], width[i], and length[i] represent the dimensions of the ith box, find the maximum possible height of a stack formed using these boxes.
A box can be rotated so that any of its dimensions becomes its height.
A box can be placed on top of another only if both dimensions of its base are strictly smaller than those of the box below.
Multiple instances of the same box can be used.

#### Examples

##### Example 1

- **Input:**
```text
height[] = [4, 1, 4, 10], width[] = [6, 2, 5, 12], length[] = [7, 3, 6, 32]
```
- **Output:**
```text
60
```
- **Explanation:** One possible arrangement of the boxes from bottom to top is shown below. Note that there can be multiple instances of a box type. Hence, the total height of this stack is 10 + 32 + 4 + 4 + 6 + 1 + 3 = 60. No other combination of boxes produces a height greater than this.

##### Example 2

- **Input:**
```text
height[] = [1, 4, 3], width[] = [2, 5, 4], length[] = [3, 6, 1]
```
- **Output:**
```text
15
```
- **Explanation:** One possible arrangement of the boxes from bottom to top is shown below: Hence, the total height of this stack is 4 + 6 + 1 + 1 + 3 = 15 No other combination of boxes produces a height greater than this.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^2)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-09-25 22:37:09
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    int n;
    int[][] boxes; // 3n orientations: {h, w, l}
    int[][] memo;

    public int solve(int i, int j) {
        if (i == n) return 0;

        if (memo[i][j + 1] != -1) return memo[i][j + 1];

        int best = solve(i + 1, j);
        int h = boxes[i][0], w = boxes[i][1], l = boxes[i][2];

        boolean fits = (j == -1) ||
                       (boxes[j][1] > w && boxes[j][2] > l) ||
                       (boxes[j][1] > l && boxes[j][2] > w);

        if (fits) {
            best = Math.max(best, h + solve(0, i));
        }

        memo[i][j + 1] = best;
        return best;
    }

    public int maxHeight(int[] height, int[] width, int[] length) {
        int m = height.length;
        boxes = new int[3 * m][3];
        for (int k = 0; k < m; k++) {
            int a = height[k], b = width[k], c = length[k];
            boxes[3*k]     = new int[]{a, b, c}; // a as height
            boxes[3*k + 1] = new int[]{b, a, c}; // b as height
            boxes[3*k + 2] = new int[]{c, a, b}; // c as height
        }
        n = 3 * m;
        memo = new int[n + 1][n + 1];
        for (int[] row : memo) java.util.Arrays.fill(row, -1);
        return solve(0, -1);
    }
}
```

*Generated on: 25/09/2026, 22:38:20*