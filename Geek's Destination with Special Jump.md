## 01. Geek's Destination with Special Jump

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/geek-and-her-destination--145724/1)

### Problem Description

**Task:** Geek starts at position 0 on the positive X-axis and needs to reach or pass position d on the positive X-axis. Geek normally follows a repeating movement pattern:Move forward by a units, taking a seconds.Move backward by b units, taking b seconds.Geek also has a special jump that moves him exactly j units forward in 1 second. He can use it at any time, even in the middle of a forward or backward movement, and the journey ends immediately after the jump.Given five integers a, b, d, l, and r. For every integer j in the range [l, r], find the minimum time required for Geek to reach or pass position d. He may either use the special jump or reach the destination using normal movement alone, whichever takes less time.Return the sum of the minimum times for all jump lengths from l to r. Since, the answer can be large, return modulo 10⁹ + 7. Note: Each jump length is considered independently.Examples:Input: a = 2, b = 1, d = 5, l = 3, r = 4Output: 5Explanation: For j = 3, Geek moves 2 units forward, then takes a jump of 3 units to reach the destination. The minimum time required is 3 seconds.For j = 4, Geek moves 1 unit forward, then takes a jump of 4 units to reach the destination. The minimum time required is 2 seconds.Total sum for the range [l, r] = 3 + 2 = 5.Input: a = 4, b = 2, d = 8, l = 2, r = 4Output: 26Explanation:For j = 2, Geek moves 4 units forward, then 2 units backward. She then moves 4 units forward again and takes a jump of 2 units to reach the destination. The minimum time required is 11 seconds.For j = 3, Geek moves 4 units forward, then 2 units backward. She then moves 3 units forward and takes a jump of 3 units to reach the destination. The minimum time required is 10 seconds.For j = 4, Geek moves 4 units forward, then takes a jump of 4 units to reach the destination. The minimum time required is 5 seconds.Total sum for the range [l, r] = 11 + 10 + 5 = 26.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(1)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (Java)

- **Submitted:** 2026-11-25 22:53:45
- **Status:** Correct
- **Marks:** 8

```java
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long cycleGain = a - b;

        // Minimum time using normal movement alone.
        long normalCycles = ceilDiv(d - a, cycleGain);
        long normalTime = d + 2L * b * normalCycles;

        // q = d - j, so the queried q values are [d-r, d-l].
        long qLow = (long) d - r;
        long qHigh = (long) d - l;

        // Find the largest q for which jumping is no slower than normal movement.
        long left = qLow, right = qHigh, best = qLow - 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (jumpTime(mid, a, b, cycleGain) <= normalTime) {
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        long answer = 0;
        long jumpHigh = Math.min(qHigh, best);

        if (qLow <= jumpHigh) {
            long smallHigh = Math.min(jumpHigh, (long) a);
            if (qLow <= smallHigh) {
                long count = smallHigh - qLow + 1;
                long sumQ = (qLow + smallHigh) * count / 2;
                answer = (answer + count + sumQ) % MOD; // jump time = 1 + q
            }

            long largeLow = Math.max(qLow, (long) a + 1);
            if (largeLow <= jumpHigh) {
                long count = jumpHigh - largeLow + 1;
                long sumQ = (largeLow + jumpHigh) * count / 2;

                // Sum ceil((q-a)/cycleGain) over this interval.
                long xLow = largeLow - a;
                long ceilSum = floorSum(
                    count, cycleGain, 1, xLow + cycleGain - 1
                );

                long sumTimes = count + sumQ + 2L * b * ceilSum;
                answer = (answer + sumTimes) % MOD;
            }
        }

        // All remaining q values use normal movement alone.
        long normalCount = (qHigh - qLow + 1) - Math.max(0, jumpHigh - qLow + 1);
        answer = (answer + (normalCount % MOD) * (normalTime % MOD)) % MOD;

        return (int) answer;
    }

    private long jumpTime(long q, long a, long b, long cycleGain) {
        if (q <= a) return 1 + q;
        return 1 + q + 2 * b * ceilDiv(q - a, cycleGain);
    }

    private long ceilDiv(long x, long y) {
        return (x + y - 1) / y;
    }

    // Returns sum for i = 0..n-1 of floor((a*i + b) / m).
    private long floorSum(long n, long m, long a, long b) {
        long result = 0;

        while (true) {
            if (a >= m) {
                result += (n - 1) * n * (a / m) / 2;
                a %= m;
            }
            if (b >= m) {
                result += n * (b / m);
                b %= m;
            }

            long yMax = a * n + b;
            if (yMax < m) break;

            n = yMax / m;
            b = yMax % m;

            long temp = m;
            m = a;
            a = temp;
        }

        return result;
    }
}
```

*Generated on: 11/25/2026, 10:54:12 PM*