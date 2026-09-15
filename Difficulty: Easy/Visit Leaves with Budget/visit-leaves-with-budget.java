/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0 ; i<s; i++) {
                Node node = q.remove();
                if (node.left == null && node.right == null) pq.add(level);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }
        int res = 0;
        int c = 0;
        while (!pq.isEmpty()) {
            int val = pq.remove();
            if (res + val <= k) {
                c++;
                res += val; 
            }
            else{
                break;
            }
        }
        return c;
    
    }
}