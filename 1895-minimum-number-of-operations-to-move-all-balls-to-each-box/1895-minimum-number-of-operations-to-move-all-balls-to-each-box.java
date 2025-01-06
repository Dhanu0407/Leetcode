class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        int operations = 0;
        int balls = 0;

        // First pass: Calculate the number of operations from left to right
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++; // Add the current box's ball count
            }
            operations += balls; // Update operations for the next box
        }

        operations = 0;
        balls = 0;

        // Second pass: Calculate the number of operations from right to left
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            if (boxes.charAt(i) == '1') {
                balls++; // Add the current box's ball count
            }
            operations += balls; // Update operations for the next box
        }

        return answer;
    }
}
