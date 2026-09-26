## 01. Minimum Cost Pizza Selection

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/pizza-mania0155/1)

### Problem Description

**Task:** Given the area of Small, Medium, and Large pizzas as s, m, and l units, and their respective costs as cs, cm, and cl, find the minimum amount of money required to buy pizzas whose total area is at least x. You may buy any number of pizzas of each type.

#### Examples

##### Example 1

- **Input:**
```text
x = 16, s = 3, m = 6, l = 9, cs = 50, cm = 150, cl = 300
```
- **Output:**
```text
300
```
- **Explanation:** We want at least 16 sq. units of Pizza. One unit of each s, m and l = 3 + 6 + 9 = 18 sq units, Cost = 500. 6 units of s = 18 sq units, Cost = 300 2 units of l = 18 sq units, Cost = 600 etc. Of all the Arrangements, Minimum Cost is Rs. 300.

##### Example 2

- **Input:**
```text
x = 10, s = 1, m = 3, l = 10, cs = 10, cm = 20, cl = 50
```
- **Output:**
```text
50
```
- **Explanation:** Of all the Arrangements possible, Minimum Cost is Rs. 50.

#### Constraints

- **1.** `1 ≤ x ≤ 5001 ≤ s ≤ m ≤ l ≤ 1001 ≤ cs ≤ cm ≤ cl ≤ 100`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(x)
- **Expected Auxiliary Space Complexity:** O(x)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-09-26 23:31:26
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int arr[][] = new int[3][2];
        arr[0] = new int[]{s,cs};
        arr[1] = new int[]{m,cm};
        arr[2] = new int[]{l,cl};
        return solve(0,0, x, arr);
    }
    int solve(int ind, int curr, int tar, int[][] arr){
        if(curr>= tar) return 0;

        if(ind>=3) return (int) 1e9;

        int take=0, notake=0;
        take = arr[ind][1]+solve(ind, curr+arr[ind][0], tar, arr);
        notake = solve(ind+1, curr, tar, arr);
        return Math.min(take, notake);
    }
}
```

*Generated on: 26/09/2026, 23:32:48*