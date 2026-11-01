## 01. Maximum Subarray Sum with One Square Allowed

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/maximum-sum-subarray--143510/1)

### Problem Description

**Task:** Given an integer array arr[], find the maximum subarray sum by squaring at most one element.Examples:Input: arr[] = [-1, -2, 3, -2, 3]Output: 10Explanation: The subarray {3, -2, 3} with squaring -2 will give the maximum sum as 3 + 4 + 3 = 10.Input: arr[] = [-4, -4, -2, 5, 2, -1]Output: 27Explanation: The subarray {5, 2} with squaring 5 will give a maximum sum of 25 + 2 = 27.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-01 22:16:29
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int maximumSubarray(int[] arr) {
        // code here
        int n = arr.length;
        int square = 0;
        int nosquare = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            int curr = arr[i];
            int newnosquare = Math.max(curr ,nosquare+curr);
            int newsquare = Math.max(curr*curr,Math.max(nosquare+curr*curr,square+curr));
            nosquare = newnosquare;
            square = newsquare;
            ans = Math.max(ans,Math.max(nosquare,square));
        }
        return ans;
    }
}
```

*Generated on: 11/1/2026, 10:17:00 PM*