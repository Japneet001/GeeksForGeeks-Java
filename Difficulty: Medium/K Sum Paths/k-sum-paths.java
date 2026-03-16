/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    
    public int dfs(Node node, int k, long currSum, HashMap<Long, Integer> map) {
        if (node == null) return 0;
        
        currSum += node.data;
        
        int count = map.getOrDefault(currSum - k, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        count += dfs(node.left, k, currSum, map);
        count += dfs(node.right, k, currSum, map);
        
        map.put(currSum, map.get(currSum) - 1);
        
        return count;
    }
    
    public int countAllPaths(Node root, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        
        return dfs(root, k, 0, map);
    }
}