import java.util.*;

class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;
        
        // Sort meetings based on start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        int busyDays = 0;
        int prevEnd = 0;  // Last occupied day

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            
            if (start > prevEnd + 1) {
                // There is a gap between previous and current meeting
                busyDays += (end - start + 1);
            } else {
                // Overlapping or touching meetings, extend the range
                busyDays += Math.max(0, end - prevEnd);
            }
            prevEnd = Math.max(prevEnd, end); // Update last occupied day
        }
        
        return days - busyDays;
    }
}
