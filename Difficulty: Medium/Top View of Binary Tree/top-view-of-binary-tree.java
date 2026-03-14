/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class Group {
        int dis;
        Node root;
        Group (int dis, Node root) {
            this.dis = dis;
            this.root = root;
        }
    }
    
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        
        Queue<Group> q = new ArrayDeque<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        q.offer (new Group(0, root));
        
        while (!q.isEmpty()) {
            int dis = q.peek().dis;
            Node node = q.peek().root;
            q.poll();
            
            if (!map.containsKey(dis))
                map.put(dis, node.data);
            
            if (node.left != null)
                q.offer (new Group(dis - 1, node.left));
            
            if (node.right != null)
                q.offer (new Group(dis + 1, node.right));
        }
        
        for (Map.Entry<Integer, Integer> em : map.entrySet()) {
            int v = em.getValue();
            ans.add(v);
        }
        return ans;
    }
}