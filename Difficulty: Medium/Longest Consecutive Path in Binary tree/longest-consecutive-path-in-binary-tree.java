/* Structure of Binary Tree Node
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
}*/
class Solution {
    public int ans = -1;
    public void solve(Node root, int len, int parent){
        if(root == null) return ;
        if(parent + 1 == root.data){
            len++;
        }
        else{
            len=1;// len starts with the current node
        }
        ans = Math.max(ans,len); // check for every node else leaf node length gets ignored
        solve(root.left, len, root.data);
        solve(root.right,len,root.data);
        
    }
    public int longestConsecutive(Node root) {
        // code here
        solve(root,0,Integer.MIN_VALUE);
        return (ans==1)?-1:ans;
    }
}