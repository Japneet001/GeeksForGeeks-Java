class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int ans = 0;
        int size = a.length;
        boolean[] used = new boolean[size];
        Arrays.fill(used, false);
        
        Queue<int[]> pqA = new PriorityQueue<>(
            (m, n) -> {
                if(m[0] == n[0]) {
                    return n[1] - m[1];
                }
                
                return n[0] - m[0];
            }
        );
        
        Queue<int[]> pqB = new PriorityQueue<>(
            (m, n) -> {
                if(m[0] == n[0]) {
                    return n[1] - m[1];
                }
                
                return n[0] - m[0];
            }
        );
        
        // Finding which one has greater value
        for(int i = 0; i < size; i++) {
            int diff = a[i] - b[i];
            
            if(diff >= 0) {
                pqA.offer( new int[] {diff, i} );
            }
            else {
                pqB.offer( new int[] {Math.abs(diff), i} );
            }
        }
        
        while(x > 0 && y > 0) {
            // Base Case
            if(pqA.isEmpty() || pqB.isEmpty()) {
                break;
            }
            
            int[] topA = pqA.peek();
            int[] topB = pqB.peek();
            
            if(topA[0] >= topB[0]) {
                pqA.poll();
                ans += a[topA[1]];
                used[topA[1]] = true;
                x--;
            }
            else {
                pqB.poll();
                ans += b[topB[1]];
                used[topB[1]] = true;
                y--;
            }
        }
        
        // If y == 0 || pqB.isEmpty()
        while(x > 0 && !pqA.isEmpty()) {
            int[] top = pqA.poll();
            ans += a[top[1]];
            used[top[1]] = true;
            x--;
        }
        
        // If x == 0 || pqA.isEmpty()
        while(y > 0 && !pqB.isEmpty()) {
            int[] top = pqB.poll();
            ans += b[top[1]];
            used[top[1]] = true;
            y--;
        }
        
        // If pqA.isEmpty() && pqB.isEmpty() || x > 0
        for(int i = 0; i < size && x > 0; i++) {
            if(!used[i]) {
                ans += a[i];
                x--;
            }
        }
        
        // If pqA.isEmpty() && pqB.isEmpty() || y > 0
        for(int i = 0; i < size && y > 0; i++) {
            if(!used[i]) {
                ans += b[i];
                y--;
            }
        }
        
        return ans;
    }
}