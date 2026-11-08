## 01. Minimum Time with 2 Scanners

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/find-the-minimum-time0253/1)

### Problem Description

**Task:** Geek has n documents that need to be scanned using two scanners. Scanner 1 takes s1 units of time to scan one document, while scanner 2 takes s2 units of time to scan one document.Both scanners can operate simultaneously, and each scanner can scan only one document at a time. A scanner can start scanning its next document immediately after finishing the current one.Find the minimum time required to scan all n documents.Examples:Input: n = 2, s1 = 2, s2 = 4

#### Examples

##### Example 1

- **Output:**
```text
2
```
- **Explanation:** The optimal approach is to scan both documents using scanner 1, which takes 2 × 1 = 2 units of time.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(log n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-08 23:04:34
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public int minTime(int n, int s1, int s2) {

        int low = 0, high = Math.min(s1, s2) * n;
        while(low < high){
            int mid = low + (high - low) / 2;
            int d =mid / s1 + mid / s2;
            if(d >= n) high = mid;
            else low = mid + 1;

        }
        return low;
    }
}
```

*Generated on: 11/8/2026, 11:05:01 PM*