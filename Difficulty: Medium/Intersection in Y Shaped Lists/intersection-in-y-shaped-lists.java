/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        if(head1 == null || head2 == null) return null;
        Node n1 = head1;
        Node n2 = head2;
        while (n1 != n2){
            n1 = (n1 == null ? head2 : n1.next);
            n2 = (n2 == null ? head1 : n2.next);
        }
        return n1;
    }
}