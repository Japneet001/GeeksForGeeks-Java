## 01. Longest Colored Path

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-colored-path--151454/1)

### Problem Description

**Task:** Given an undirected acyclic graph (tree) with n nodes numbered from 1 to n. Each node is colored either Red (R) or Blue (B).The colors of the nodes are given by a string s of length n, where:s[i] = 'R' means node i + 1 is Red.s[i] = 'B' means node i + 1 is Blue.You are also given a list of n - 1 edges edges[][], where each edges[i] = [u, v] represents an undirected edge between nodes u and v.You can start from any node and traverse along the edges to form a path.A path is called valid if, once you visit a Blue node, you cannot visit any Red node after it on the same path.In other words, a valid path must have the following form:Only Red nodes, orOnly Blue nodes, orSome Red nodes followed by some Blue nodes.A path containing a pattern like Blue - > Red is invalid.Find the maximum number of nodes in a valid path.Examples:Input: s = "RBB", edges = [[1, 2], [1, 3]] Output: 2Explanation: The longest path is either 1 - > 2 or 1 - > 3. In both cases, the length of the path is 2.Input: s = "BB", edges = [[1, 2]]

#### Examples

##### Example 1

- **Output:**
```text
2Explanation: The longest path is 1 - > 2. The length of the path is 2.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-09-27 22:39:39
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    public int longestPath(String s, int[][] edges) {
        int n = s.length();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Result red = process('R', s, adj);
        Result blue = process('B', s, adj);

        int bestMix = 0;

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;

            if (s.charAt(u) == 'R' && s.charAt(v) == 'B') {
                bestMix = Math.max(bestMix, red.far[u] + blue.far[v] + 2);
            } else if (s.charAt(u) == 'B' && s.charAt(v) == 'R') {
                bestMix = Math.max(bestMix, red.far[v] + blue.far[u] + 2);
            }
        }

        return Math.max(Math.max(red.diameter, blue.diameter), bestMix);
    }

    static class Result {
        int[] far;
        int diameter;

        Result(int[] far, int diameter) {
            this.far = far;
            this.diameter = diameter;
        }
    }

    private Result process(char col, String s, List<List<Integer>> adj) {
        int n = s.length();
        int[] far = new int[n];
        boolean[] seen = new boolean[n];
        int diameterNodes = 0;

        for (int src = 0; src < n; src++) {
            if (seen[src] || s.charAt(src) != col) continue;

            List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(src);
            seen[src] = true;

            while (!q.isEmpty()) {
                int u = q.poll();
                comp.add(u);

                for (int v : adj.get(u)) {
                    if (!seen[v] && s.charAt(v) == col) {
                        seen[v] = true;
                        q.add(v);
                    }
                }
            }

            int[] bfsStart = bfs(src, col, s, adj);
            int A = bfsStart[0];

            int[] bfsA = bfs(A, col, s, adj);
            int B = bfsA[0];
            Map<Integer, Integer> distA = getDistMap(A, col, s, adj);
            Map<Integer, Integer> distB = getDistMap(B, col, s, adj);

            int diameter = distA.getOrDefault(B, 0) + 1;
            diameterNodes = Math.max(diameterNodes, diameter);

            for (int node : comp) {
                int d1 = distA.getOrDefault(node, 0);
                int d2 = distB.getOrDefault(node, 0);
                far[node] = Math.max(d1, d2);
            }
        }

        return new Result(far, diameterNodes);
    }

    private int[] bfs(int start, char col, String s, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        int farNode = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (s.charAt(v) != col || dist.containsKey(v)) continue;

                dist.put(v, dist.get(u) + 1);
                q.add(v);

                if (dist.get(v) > dist.get(farNode)) {
                    farNode = v;
                }
            }
        }

        return new int[]{farNode};
    }

    private Map<Integer, Integer> getDistMap(int start, char col, String s, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();

        q.add(start);
        dist.put(start, 0);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                if (s.charAt(v) != col || dist.containsKey(v)) continue;

                dist.put(v, dist.get(u) + 1);
                q.add(v);
            }
        }

        return dist;
    }
}
```

*Generated on: 27/09/2026, 22:40:11*