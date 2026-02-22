class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            set.add(a[i]);
        }
        
        for(int j = 0; j < b.length; j++){
            set.add(b[j]);
        }
        
        for(int ele: set){
            ans.add(ele);
        }
        
        return ans;
    }
}