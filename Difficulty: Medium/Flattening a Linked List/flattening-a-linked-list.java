/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    private Node merge(Node list1, Node list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        Node ans;
        
        if(list1.data < list2.data){
            ans = list1;
            ans.bottom = merge(list1.bottom, list2);
        }
        else{
            ans = list2;
            ans.bottom = merge(list1, list2.bottom);
        }
        
        ans.next = null;
        return ans;
    }
    
    public Node flatten(Node root) {
        // code here
        if(root == null || root.next == null) return root;
        
        root.next = flatten(root.next);
        merge(root, root.next);
        
        return root;
    }
}