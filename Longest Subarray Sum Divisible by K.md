## 01. Longest Subarray Sum Divisible by K

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1)

### Problem Description

**Task:** Given an array arr[] and a positive integer k, find the length of the longest subarray whose sum is divisible by k.Note: If there is no subarray with sum divisible by k, then return 0.Examples:Input: arr[] = [2, 7, 6, 1, 4, 5], k = 3

#### Examples

##### Example 1

- **Output:**
```text
2
```
- **Explanation:** The subarray is [2, -2] has sum = 0, which is divisible by 2.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(min(n, k))

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-22 23:39:48
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int longestSubarrayDivK(int[] arr, int k) {
        // code here
       HashMap<Integer,Integer>map =  new HashMap<>();
       long sum = 0;
       int maxLen = 0;
       map.put(0,-1);
       for(int i = 0;i<arr.length;i++){
           sum+=arr[i];
           int rem = (int)(((sum%k)+k)%k);
           if(map.containsKey(rem)){
               maxLen = Math.max(maxLen,i-map.get(rem));
           } else{
               map.put(rem,i);
           }
       }
       return maxLen;
    }
}
```

*Generated on: 11/22/2026, 11:40:17 PM*