/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        func(root, 0, map);
        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }
    private void func(Node root ,int level,TreeMap<Integer,Integer> tm){
        if(root==null) return;
        
        int sum=0;
        if(tm.containsKey(level)) sum=tm.get(level)+root.data;
        else sum=root.data;
        
         tm.put(level,sum);
        func(root.left,level-1,tm);
        func(root.right,level+1,tm);
    }
}