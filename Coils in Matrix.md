## 01. Coils in Matrix

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/form-coils-in-a-matrix4726/1)

### Problem Description

**Task:** Given a positive integer n, consider a 4n * 4n matrix filled with integers from 1 to (4n) * (4n) in row-major order (left to right, top to bottom). Form two coils from the matrix:The first coil starts from the top-left cell (0, 0) and spirals inward.The second coil starts from the bottom-right cell (4n - 1, 4n - 1) and spirals inward in the opposite direction.Return these two coils in the same order.Examples:Input: n = 1Output: [[1, 5, 9, 13, 14, 15, 11, 7], [16, 12, 8, 4, 3, 2, 6, 10]]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^2)
- **Expected Auxiliary Space Complexity:** O(n^2)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-03 22:41:12
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int nn = 4 * n;

        ArrayList<Integer> first = new ArrayList<>();
        int top = 0;
        int bottom = nn - 1;
        int right = nn - 2;
        int left = 0;
        while(top <= bottom && left <= right){
            for(int i = top; i <= bottom; i++){
                first.add(((4 * n * i) + left + 1));
            }
            left++;
            
            for(int i = left; i <= right; i++){
                first.add(((4 * n * bottom) + i + 1));
            }
            bottom--;
            
            top++;
            left++;
            
            for(int i = bottom; i >= top; i--){
                first.add(((4 * n * i) + right + 1));
            }
            
            bottom--;
            right--;
            
            for(int i = right; i >= left; i--){
                first.add(((4 * n * top) + i + 1));
            }
            
            top++;
            right--;
        }
        result.add(first);

        ArrayList<Integer> second = new ArrayList<>();
        top = 0;
        bottom = nn - 1;
        right = nn - 1;
        left = 1;
        while(top <= bottom && left <= right){
            for(int i = bottom; i >= top; i--){
                second.add(((4 * n * i) + right + 1) );
            }
            right--;
            
            for(int i = right; i >= left; i--){
                second.add(((4 * n * top) + i + 1));
            }
            top++;
            
            bottom--;
            right--;
            for(int i = top; i <= bottom; i++){
                second.add(((4 * n * i) + left + 1));
            }
            
            top++;
            left++;;
            
            for(int i = left; i <= right; i++){
                second.add(((4 * n * bottom) + i + 1));
            }
            
            bottom--;
            left++;
        }
        result.add(second);
        return result;
    }   
}
```

*Generated on: 03/10/2026, 22:41:45*