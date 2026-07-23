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
    private void helper(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        ans.add(root.data);
        helper(root.left, ans);
        helper(root.right, ans);
    }
    
    public ArrayList<Integer> preOrder(Node root) {
        //  code here
        ArrayList<Integer> answer = new ArrayList<>();
        helper(root, answer);
        return answer;
    }
}