class Solution {
    public int countSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);   // base case

        int prefixSum = 0;
        int oddCount = 0;

        for (int num : arr) {
            // odd = 1, even = 0
            prefixSum += (num % 2);

            if (map.containsKey(prefixSum - k)) {
                oddCount += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return oddCount;
    }
}