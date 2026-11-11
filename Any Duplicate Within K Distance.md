## 01. Any Duplicate Within K Distance

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/kth-distance3757/1)

### Problem Description

**Task:** Given an array of integers, arr[] and an integer k, check whether there exist two distinct indices i and j such that arr[i] is equal to arr[j] and the absolute difference between i and j is at most k.Examples:Input: arr[] = [1, 5, 4, 5, 1], k = 3Output: trueExplanation: The element 5 occurs at indices 1 and 3. Their distance is |3 - 1| = 2, which is less than or equal to k.Input: arr[] = [10, 2, 3, 4, 10, 5], k = 3Output: falseExplanation: The element 10 occurs at indices 0 and 4. Their distance is |4 - 0| = 4, which is greater than k. Hence, no duplicate exists within the given distance.Input: arr[] = [5, 1, 3, 2, 4], k = 3Output: falseExplanation: All elements are distinct, so no duplicate exists.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(min(n, k))

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-11 19:49:02
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public boolean checkWithinK(int[] arr, int k) {
        // code here
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<arr.length;i++) {
            if(map.containsKey(arr[i])) {
                if(i-map.get(arr[i]) <= k) {
                    return true;
                }
            } 
            map.put(arr[i],i);
        }
        return false;
    }
}
```

*Generated on: 11/11/2026, 7:49:36 PM*