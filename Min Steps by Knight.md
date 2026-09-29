## 01. Min Steps by Knight

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/steps-by-knight5927/1)

### Problem Description

**Task:** Given a square chessboard of size n × n, the initial position knightPos and target position targetPos of a Knight are given. Find the minimum number of moves required for the Knight to reach targetPos.A Knight moves in an L-shape, covering 2 cells in one direction and 1 cell perpendicular to it. From (x, y), it can move to: (x ± 2, y ± 1) and (x ± 1, y ± 2)This gives at most 8 possible moves:Note: The positions are given using 1-based indexing.Examples:Input: n = 3, knightPos[] = [3, 3], targetPos[] = [1, 2]Output: 1Explanation: Knight takes 1 step to reach from (3, 3) to (1 ,2).Input: n = 6, knightPos[] = [1, 3], targetPos[] = [5, 1]

#### Examples

##### Example 1

- **Output:**
```text
2
```
- **Explanation:** In above diagram Knight takes 2 step to reach from (1, 3) to (5, 0): (1, 3) - > (3, 2) - > (5, 1)

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^2)
- **Expected Auxiliary Space Complexity:** O(n^2)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-09-29 22:22:33
- **Status:** Correct
- **Marks:** 4

```java
class Solution {

	class Pair {
		int r;
		int c;
		int step;

		Pair(int r, int c, int step) {
			this.r = r;
			this.c = c;
			this.step = step;
		}
	}

	int directions[][] = {{-2, -1}, {-1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}, {2, -1}, {1, -2}};

	public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
		// code here
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(knightPos[0] - 1, knightPos[1] - 1, 0));
		boolean isVis[][] = new boolean[n][n];
		int min = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			Pair curr = q.remove();
			int r = curr.r;
			int c = curr.c;
			int steps = curr.step;

			if (r == (targetPos[0] - 1) && c == (targetPos[1] - 1)) {
				min = Math.min(min, steps);
				continue;
			}

			for (int dir[] : directions) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n || isVis[nr][nc]) {
					continue;
				}
				isVis[nr][nc] = true;

				q.add(new Pair(nr, nc, steps+1));
			}
		}

		return min;
	}
}
```

*Generated on: 29/09/2026, 22:23:10*