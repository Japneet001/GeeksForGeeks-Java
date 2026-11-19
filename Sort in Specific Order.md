## 01. Sort in Specific Order

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/sort-in-specific-order2422/1)

### Problem Description

**Task:** Given an array arr[] of non-negative integers. Your need to sort them so that The first part of the array contains odd numbers sorted in descending order.The rest of the portion contains even numbers sorted in ascending order.Examples:Input: arr[] = [1, 2, 3, 5, 4, 7, 10]

#### Examples

##### Example 1

- **Output:**
```text
[7, 5, 3, 1, 0, 2, 4]Explanation: 7, 5, 3, 1 are odd numbers in descending order and 0, 2, 4 are even numbers in ascending order.
```
- **Explanation:** 7, 5, 3, 1 are odd numbers in descending order and 2, 4, 10 are even numbers in ascending order.Input: arr[] = [0, 4, 5, 3, 7, 2, 1]

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-19 23:26:59
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public void sortIt(int[] arr) {

        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // Separate odd and even numbers
        for(int num : arr) {
            if(num % 2 != 0) {
                odd.add(num);
            }
            else {
                even.add(num);
            }
        }

        // Sort odd numbers in descending order
        Collections.sort(odd, Collections.reverseOrder());

        // Sort even numbers in ascending order
        Collections.sort(even);

        // Put odd numbers first
        int index = 0;

        for(int num : odd) {
            arr[index++] = num;
        }

        // Put even numbers next
        for(int num : even) {
            arr[index++] = num;
        }
    }
}
```

*Generated on: 11/19/2026, 11:27:56 PM*