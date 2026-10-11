## 01. Sort Two Parts Sorted

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/sort-the-half-sorted2157/1)

### Problem Description

**Task:** Given an integer array arr[] where the two parts around a break point are individually sorted, merge them into a single sorted array. The break point can be anywhere in the array, including at the beginning or end.Examples:Input: arr[] = [2, 3, 8, -1, 7, 10]

#### Examples

##### Example 1

- **Output:**
```text
[10, 20, 30]
```
- **Explanation:** One part is empty and the other part is whole array which is already sorted.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-11 23:17:26
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public void mergeTwoParts(int[] arr) {
        int n = arr.length;

        int mid = 1;
        while (mid < n && arr[mid - 1] <= arr[mid]) mid++;

        if (mid == n) return;

        int[] temp = new int[n];
        int i = 0, j = mid, k = 0;

        while (i < mid && j < n) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j < n)   temp[k++] = arr[j++];

        for (int x = 0; x < n; x++) arr[x] = temp[x];
    }
}
```

*Generated on: 11/10/2026, 23:18:12*