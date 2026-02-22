class Solution {
    public long subarrayXor(int arr[], int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        int prefixXor = 0;

        for (int num : arr) {
            prefixXor ^= num;

            // Case 1: subarray from start has XOR = k
            if (prefixXor == k) {
                count++;
            }

            // Case 2: subarray ending here has XOR = k
            int target = prefixXor ^ k;
            if (freq.containsKey(target)) {
                count += freq.get(target);
            }

            // Update frequency of prefixXor
            freq.put(prefixXor, freq.getOrDefault(prefixXor, 0) + 1);
        }

        return count;

    }
}