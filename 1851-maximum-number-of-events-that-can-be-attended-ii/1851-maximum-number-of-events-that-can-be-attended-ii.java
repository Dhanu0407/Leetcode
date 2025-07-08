import java.util.*;

class Solution {
    public int maxValue(int[][] events, int k) {
        // Sort events by start time (or end time)
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Memoization: dp[i][k] = max value from index i with k events left
        int n = events.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return dfs(0, k, events, dp);
    }

    // Binary search to find the next non-overlapping event
    private int findNextEvent(int[][] events, int currentEnd) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > currentEnd)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }

    private int dfs(int index, int remaining, int[][] events, int[][] dp) {
        if (index >= events.length || remaining == 0)
            return 0;

        if (dp[index][remaining] != -1)
            return dp[index][remaining];

        // Option 1: Skip this event
        int notTake = dfs(index + 1, remaining, events, dp);

        // Option 2: Take this event
        int nextIndex = findNextEvent(events, events[index][1]);
        int take = events[index][2] + dfs(nextIndex, remaining - 1, events, dp);

        dp[index][remaining] = Math.max(take, notTake);
        return dp[index][remaining];
    }
}
