class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1]; // Create an array to store net shifts
        
        // Process the shifts using a prefix sum approach
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            
            shiftArray[start] += (direction == 1) ? 1 : -1;
            shiftArray[end + 1] += (direction == 1) ? -1 : 1;
        }
        
        // Compute the cumulative shifts
        int cumulativeShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftArray[i];
            int netShift = (cumulativeShift % 26 + 26) % 26; // Handle negative shifts
            result[i] = (char) ('a' + (result[i] - 'a' + netShift) % 26);
        }
        
        return new String(result);
    }
}
