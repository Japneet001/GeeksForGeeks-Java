class Solution {
    public boolean isSumOfConsecutive(int n) {
        // code here
        return n > 2 && (n & (n - 1)) != 0;
    }
}