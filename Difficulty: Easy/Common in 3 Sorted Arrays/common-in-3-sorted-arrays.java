class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while((i < aLen) && (j < bLen) && (k < cLen)){
            if(a[i] == b[j] && b[j] == c[k]){
                if(ans.isEmpty() || ans.get(ans.size() - 1) != a[i]){
                    ans.add(a[i]);
                }
                i++;
                j++;
                k++;
            }
            else {
                int min = Math.min(a[i], Math.min(b[j], c[k]));

                if (a[i] == min) i++;
                if (b[j] == min) j++;
                if (c[k] == min) k++;
            }
        }
        
        return ans;
    }
}