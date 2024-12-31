class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Initialize the last day of travel
        int lastDay = days[days.length - 1];
        int firstDay = days[0];
        
        // Create a DP array to store minimum costs
        int[] dp = new int[lastDay + 1];
        
        // Boolean array to mark the travel days
        boolean[] isTravelDay = new boolean[lastDay + 1];
        for (int day : days) {
            isTravelDay[day] = true;
        }
        
        // Fill the DP table
        for (int i = firstDay; i <= lastDay; i++) {
            if (!isTravelDay[i]) {
                // If it's not a travel day, cost remains the same as the previous day
                dp[i] = dp[i - 1];
            } else {
                // Calculate minimum cost considering all ticket options
                int cost1 = dp[Math.max(0, i - 1)] + costs[0];  // 1-day pass
                int cost7 = dp[Math.max(0, i - 7)] + costs[1];  // 7-day pass
                int cost30 = dp[Math.max(0, i - 30)] + costs[2]; // 30-day pass
                
                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }
        }
        
        // The cost at the last travel day gives the result
        return dp[lastDay];
    }
}
