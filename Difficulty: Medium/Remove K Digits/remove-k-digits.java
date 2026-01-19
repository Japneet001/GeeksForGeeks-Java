class Solution {
    public String removeKdig(String s, int k) {
        if (k >= s.length()) return "0";

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (k > 0 && stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) > c) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(c);
        }

        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }
        
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = stack.substring(idx);
        return result.length() == 0 ? "0" : result;
    }
}