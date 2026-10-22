## 01. Palindrome with Replacement

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/palindrome-with-minimum-sum--170648/1)

### Problem Description

**Task:** Given a string s consisting of lowercase English letters and the character '?',
Replace every '?' with a lowercase English letter such that the resulting string is a palindrome.
If it is possible to form a palindrome, return the minimum possible sum of the absolute ASCII differences between every pair of adjacent characters in the resulting string.
If it is not possible to form a palindrome, return -1.

#### Examples

##### Example 1

- **Input:**
```text
s = a???c??c????
```
- **Output:**
```text
4
```
- **Explanation:** One optimal palindrome is "abbbccccbbba". The sum of the absolute ASCII differences between adjacent characters is 1 + 0 + 0 + 1 + 0 + 0 + 0 + 1 + 0 + 0 + 1 = 4, which is the minimum possible.

##### Example 2

- **Input:**
```text
s = a???c??c???c
```
- **Output:**
```text
-1
```
- **Explanation:** It is not possible to replace the '?' characters to make the string a palindrome because the first and last characters are different and cannot be changed.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-10-22 23:29:51
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public int minimumSum(String s) {
        // code here
        char[] arr = s.toCharArray();
        int n = arr.length;

        for(int i = 0; i<n/2; i++){
            int j = n - 1 - i;

            if(arr[i] != '?' && arr[j] != '?'){
                if(arr[i] != arr[j]) return -1;
            }
            else if(arr[i] == '?' && arr[j] != '?'){
                arr[i] = arr[j];
            }
            else if(arr[i] != '?' && arr[j] == '?'){
                arr[j] = arr[j];
            }
        }

        int half = (n+1)/2;
 
        char firstKnown = 'a';

        for(int i = 0; i<half; i++){
            if(arr[i] != '?'){
                firstKnown = arr[i];
                break;
            }
        }

        for(int i = 0; i<half; i++){
            if(arr[i] == '?') arr[i] = firstKnown;
            else break;
        }

        for(int i = 1; i<half; i++){
            if(arr[i] == '?') arr[i] = arr[i-1];
        }

        for(int i = 0; i<n/2; i++){
            arr[n-1-i] = arr[i];
        }

        int sum = 0;

        for(int i = 0; i<n-1; i++){
            sum += Math.abs(arr[i] - arr[i+1]);
        }

        return sum;
    }
}
```

*Generated on: 10/22/2026, 11:30:35 PM*