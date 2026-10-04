## 01. Perimeter of Shapes in Binary Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/find-perimeter-of-shapes/1)

### Problem Description

**Task:** Given a binary matrix mat[][] of size n × m, where each cell contains either 0 or 1, find the total perimeter of all figures formed by cells containing 1s. Two cells are considered adjacent if they share a common side.
A single cell containing 1 has a perimeter of 4, whereas two adjacent cells containing 1 (i.e., 11) together have a perimeter of 6.

#### Examples

##### Example 1

- **Input:**
```text
mat[][] = [[0,1,0,0,0], [1,1,1,0,0], [1,0,0,0,0]]Output: 12Explanation: The five cells form a single figure. Hence, the perimeter of the figure is 12.
```

##### Example 2

- **Input:**
```text
mat[][] = [[1,0], [1,1]]Output: 8Explanation: The two adjacent cells share one common side. Hence, the perimeter of the figure is 6.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-04 23:56:01
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int findPerimeter(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int perimeter = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    perimeter += 4;

                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];

                        if (r >= 0 && r < n && c >= 0 && c < m
                                && mat[r][c] == 1) {
                            perimeter--;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}
```

*Generated on: 04/10/2026, 23:56:32*