## 01. Path Exists Between Two Vertices

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/path-exists/1)

### Problem Description

**Task:** Given an undirected graph with V vertices numbered from 0 to V - 1, represented by an adjacency list adj[][], where adj[i] contains all vertices adjacent to vertex i. Also given two vertices u and v, check whether a path exists between them.Return true if a path exists, otherwise return false.Examples: Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 1, v = 5Output: falseExplanation: There is no path from vertex 1 to vertex 5.Input: adj[][] = [[2, 3], [2], [0, 1], [0], [5], [4]], u = 2, v = 3

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** We can reach vertex 3 from vertex 2 via vertex 0.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(V + E)
- **Expected Auxiliary Space Complexity:** O(V + E)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-28 19:22:56
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(nei , adj , visited);
            }
        }
    }
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // code here
        boolean[] visited = new boolean[adj.size()+1];
        dfs(u , adj , visited);
        return visited[v] == true;
    }
}
```

*Generated on: 11/28/2026, 7:23:25 PM*