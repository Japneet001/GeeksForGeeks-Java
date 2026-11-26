## 01. Range Vowel Count Queries

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/range-vowel-count-queries-static/1)

### Problem Description

**Task:** Given a string s and a 2D array queries[][], where each query consists of two integers l and r, find the number of vowels in the substring s[l....r] for each query. The substring includes both indices l and r. Return an array containing the answers to all queries in the order they are given.Examples:Input: s = "geeksforgeeks", queries[][] = [[1, 3], [2, 4], [1, 9]]Output: [2, 1, 4]Explanation:Query 1: "eek" has 2 vowels (e, e).Query 2: "eks" has 1 vowel (e).Query 3: "eeksforge" has 4 vowels (e, e, o, e).Input: s = "helloworld", queries[][] = [[0, 4], [5, 9], [0, 9]]Output: [2, 1, 3]Explanation:Query 1: "hello" has 2 vowels (e, o).Query 2: "world" has 1 vowel (o).Query 3: "helloworld" has 3 vowels (e, o, o).

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-26 22:31:58
- **Status:** Correct
- **Marks:** 4

```java
class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        Set<Character> vowels = new HashSet<>(Set.of('a','e','i','o','u'));

        int count=0;

        for(int i=0; i<s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            } 
            map.put(i,count);
        }

        // System.out.println(map.toString());

        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] q :queries){
            int start = map.getOrDefault(q[0]-1,0);
            int end = map.getOrDefault(q[1],0);
            ans.add(end-start);
        }
        return ans;
    }
}
```

*Generated on: 11/26/2026, 10:32:29 PM*