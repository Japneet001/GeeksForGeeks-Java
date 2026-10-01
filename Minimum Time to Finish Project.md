## 01. Minimum Time to Finish Project

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/project-manager--141631/1)

### Problem Description

**Task:** An IT company is working on a large project consisting of n modules. The given array time required (in months) to complete the i^th module is stored in the array duration[]. The array dependencies[][], where dependencies[i] = [u, v], indicates that module v can be started only after module u is completed. Multiple modules can be worked on simultaneously as long as all their dependencies have been completed. Find the minimum time required to complete the entire project. If the project cannot be completed due to a cyclic dependency, return -1. A module is never dependent on itself.ExamplesInput: duration[] = [10, 20, 30, 10, 30, 20], dependencies[][] = [[5, 2], [5, 0], [4, 0], [4, 1], [2, 3], [3, 1]]

#### Examples

##### Example 1

- **Output:**
```text
-1
```
- **Explanation:** There is a cycle in the dependency graph hence the project cannot be completed.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n + m)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-01 22:17:05
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int minTime(int[] duration, int[][] dependencies) {
        int n = duration.length;

        ArrayList<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] edge : dependencies) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Modules with no dependencies can start immediately
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        // Earliest completion time of each module
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = duration[i];
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            processed++;
            answer = Math.max(answer, dp[u]);
            for (int v : graph[u]) {
                // v can start only after u is completed
                dp[v] = Math.max(dp[v], dp[u] + duration[v]);
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        // If not all modules were processed, there is a cycle
        if (processed != n) return -1;

        return answer;
    }
}
```

*Generated on: 01/10/2026, 22:17:38*