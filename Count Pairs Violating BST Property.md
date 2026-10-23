## 01. Count Pairs Violating BST Property

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/pairs-violating-bst-property--212515/1)

### Problem Description

**Task:** Given root of a binary tree in which all node values are distinct, count pairs of nodes that violate any of the following Binary Search Tree (BST) properties. All values in the left subtree are strictly smaller.All values in the right subtree are strictly greater.Examples:Input: root[] = [10, 50, 40, N, N, 20, 30]Output: 5

#### Examples

##### Example 1

- **Explanation:** There are total 10 pairs (80, 30), (80, 60), (80, 50), (30, 60), (40, 70), (40, 30), (40, 50), (70, 30), (70, 60), (70, 50) which violate the BST properties.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-23 22:56:02
- **Status:** Correct
- **Marks:** 4

```java
/* BST Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int pairsViolatingBST(Node root) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        inorder(root, values);
        return countInversions(values);
    }

    private void inorder(Node root, java.util.List<Integer> values) {
        if (root == null) {
            return;
        }

        inorder(root.left, values);
        values.add(root.data);
        inorder(root.right, values);
    }

    private int countInversions(java.util.List<Integer> values) {
        int[] arr = values.stream().mapToInt(Integer::intValue).toArray();
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, temp, left, mid);
        count += mergeSort(arr, temp, mid + 1, right);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return count;
    }
}
```

*Generated on: 10/23/2026, 10:56:33 PM*