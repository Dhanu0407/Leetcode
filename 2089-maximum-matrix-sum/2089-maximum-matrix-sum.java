class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0; // To store the total sum of absolute values
        int minAbsValue = Integer.MAX_VALUE; // To track the smallest absolute value
        int negativeCount = 0; // To count the number of negative elements
        
        // Traverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                sum += Math.abs(value); // Add the absolute value to the sum
                if (value < 0) {
                    negativeCount++; // Increment negative count if the value is negative
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value)); // Update minimum absolute value
            }
        }
        
        // If the number of negatives is odd, subtract twice the smallest absolute value
        if (negativeCount % 2 != 0) {
            sum -= 2 * minAbsValue;
        }
        
        return sum;
    }
}
