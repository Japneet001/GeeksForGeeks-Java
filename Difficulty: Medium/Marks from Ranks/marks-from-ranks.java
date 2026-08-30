class Solution {
    public ArrayList<Integer> getMarks(int[] l, int[] r, int[] rank) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        ArrayList<Integer> res=new ArrayList<>();
        int n=l.length;
        for(int i=0;i<n;i++){
            for(int j=l[i];j<=r[i];j++){
                al.add(j);
            }
        }
        for(int x:rank){
            res.add(al.get(x-1));
        }
        return res;
    }
}