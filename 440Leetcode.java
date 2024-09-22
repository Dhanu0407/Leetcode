class Solution {
    public int findKthNumber(int n, int k) {
        int currNum = 1;  // Start from 1 since lexicographical order begins with 1
        k--;  // Decrement k since we're starting with 1 as the first number

        while (k > 0) {
            int steps = countSteps(n, currNum, currNum + 1);
            if (steps <= k) {
                currNum += 1;  // Move to the next sibling
                k -= steps;    // Decrement k by the number of steps skipped
            } else {
                currNum *= 10;  // Move deeper into the tree (lexicographically)
                k--;            // Move to the next number in this subtree
            }
        }
        return currNum;
    }

    // Helper function to calculate the steps between two numbers in lexicographical order
    private int countSteps(int n, long curr, long next) {
        int steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
