## 01. Maximum Height Disc Stack

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/stacking-up-discs1315/1)

### Problem Description

**Task:** Given two arrays r[] and h[] of size n, where r[i] and h[i] represent the radius and height of the i-th circular disc, respectively. A disc can be placed above another disc only if both its radius and height are strictly smaller than those of the disc below it. Find the maximum possible height of a stack that can be formed using the given discs. Each disc can be used at most once.Examples:Input: r[] = [5, 7, 3], h[] = [6, 5, 4]

#### Examples

##### Example 1

- **Output:**
```text
7
```
- **Explanation:** Neither disc can be placed above the other because both required dimensions are not strictly smaller. Therefore, the maximum possible height is 7.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-09-24 22:26:45
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] bit = new int[1002];
        int answer = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int best = query(bit, height - 1);
                dp[k - i] = best + height;
                answer = Math.max(answer, dp[k - i]);
            }

            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return answer;
    }
        
    private int query(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result = Math.max(result, bit[index]);
            index -= index & -index;
        }

        return result;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-09-24 22:24:17
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] bit = new int[1002];
        int answer = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int best = query(bit, height - 1);
                dp[k - i] = best + height;
                answer = Math.max(answer, dp[k - i]);
            }

            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return answer;
    }
        
    private int query(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result = Math.max(result, bit[index]);
            index -= index & -index;
        }

        return result;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-09-24 22:22:05
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] bit = new int[1002];
        int answer = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int best = query(bit, height - 1);
                dp[k - i] = best + height;
                answer = Math.max(answer, dp[k - i]);
            }

            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return answer;
    }
        
    private int query(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result = Math.max(result, bit[index]);
            index -= index & -index;
        }

        return result;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-09-24 22:08:21
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] bit = new int[1002];
        int answer = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int best = query(bit, height - 1);
                dp[k - i] = best + height;
                answer = Math.max(answer, dp[k - i]);
            }

            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return answer;
    }
        
    private int query(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result = Math.max(result, bit[index]);
            index -= index & -index;
        }

        return result;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-09-24 22:07:50
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    public int maxStackHeight(int[] r, int[] h) {
        // code here
        int n = r.length;
        int[][] discs = new int[n][2];

        for (int i = 0; i < n; i++) {
            discs[i][0] = r[i];
            discs[i][1] = h[i];
        }

        Arrays.sort(discs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] bit = new int[1002];
        int answer = 0;
        int i = 0;

        while (i < n) {
            int j = i;
            while (j < n && discs[j][0] == discs[i][0]) {
                j++;
            }

            int[] dp = new int[j - i];
            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                int best = query(bit, height - 1);
                dp[k - i] = best + height;
                answer = Math.max(answer, dp[k - i]);
            }

            for (int k = i; k < j; k++) {
                int height = discs[k][1];
                update(bit, height, dp[k - i]);
            }
            i = j;
        }
        return answer;
    }
        
    private int query(int[] bit, int index) {
        int result = 0;

        while (index > 0) {
            result = Math.max(result, bit[index]);
            index -= index & -index;
        }

        return result;
    }

    private void update(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] = Math.max(bit[index], value);
            index += index & -index;
        }
    }
}
```

*Generated on: 24/09/2026, 22:28:43*