class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int lenA = a.length;
        int lenB = b.length;
        int i = 0;
        int j = 0;
        
        while(i < lenA && j < lenB){
            if(a[i] < b[j]) i++;
            else if(a[i] > b[j]) j++;
            else {
                if(ans.size() == 0 || ans.getLast() != a[i]){
                    ans.add(a[i]);
                }
                i++;
                j++;
            }
        }
        
        return ans;
    }
}