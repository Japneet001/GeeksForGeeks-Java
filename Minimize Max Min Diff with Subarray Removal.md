## 01. Minimize Max Min Diff with Subarray Removal

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimize-the-difference/1)

### Problem Description

**Task:** You are given an array arr[] of size n. You need to remove a subarray of size k , such that the difference between the maximum and minimum values of the remaining array is minimized. Find the minimum value obtained after performing the operation of the removal of the subarray.Examples:Input: arr = [1, 2, 3, 4, 5], k = 3 Output: 1Explanation: We remove first subarray of length 3, the remaining array is [4,5] and the difference of maximum and minimum element is 1 i.e 5 - 4 = 1Input: arr = [2, 3, 1, 4, 6, 7], k = 3Output: 2Explanation: If we remove the subarray [2,3,1] then remaining array is [4,6,7] and the difference = 7-4 = 3If we remove the subarray [3,1,4] then remaining array is [2,6,7] and the difference = 7-2 = 5If we remove the subarray [1,4,6] then remaining array is [2,3,7] and the difference = 7-2 = 5If we remove the subarray [4,6,7] then remaining array is [2,3,1] and the difference = 3-1 = 2So the answer is min(3,5,5,2) = 2

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-26 23:00:28
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int minDiff(int k, int[] arr) {
        // code here
        int n = arr.length;
        Node[] nodes = new Node[n];
        int min = Integer.MAX_VALUE, max = 0;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            nodes[i] = new Node(max, min, 0, Integer.MAX_VALUE);
        }

        min = Integer.MAX_VALUE;
        max = 0;

        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            Node node = nodes[i];
            node.nextLarge = max;
            node.nextMin = min;
        }

        int i = 0, j = k - 1, ans = Integer.MAX_VALUE;

        while (j < n) {
            int a = 0, b = 0, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
            if (i > 0) {
                a = nodes[i - 1].prevLarge;
                c = nodes[i - 1].prevMin;
            }
            if (j < n - 1) {
                b = nodes[j + 1].nextLarge;
                d = nodes[j + 1].nextMin;
            }
            max = Math.max(a, b);
            min = Math.min(c, d);
            ans = Math.min(ans, max - min);
            j++;
            i++;
        }
        return ans;
    }
}

class Node {
    int prevLarge, nextLarge, prevMin, nextMin;

    public Node(int pl, int pm, int nl, int nm) {
        prevLarge = pl;
        prevMin = pm;
        nextLarge = nl;
        nextMin = nm;
    }
}
```

*Generated on: 10/26/2026, 11:01:05 PM*