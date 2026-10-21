## 01. Minimum Sum Subarray

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1)

### Problem Description

**Task:** Given an array arr[], find the minimum sum of a subarray containing atleast one element in the given array.Examples:Input: arr[] = [3, -4, 2, -3, -1, 7, -5]

#### Examples

##### Example 1

- **Output:**
```text
1
```
- **Explanation:** The subarray [1] has the minimum sum, which is 1.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-21 16:17:04
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    int minSubarraySum(int[] arr) {
        int currentSum = arr[0];
        int minSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.min(arr[i], currentSum + arr[i]);
            minSum = Math.min(minSum, currentSum);
        }

        return minSum;
    }
}
```

*Generated on: 10/21/2026, 4:18:01 PM*