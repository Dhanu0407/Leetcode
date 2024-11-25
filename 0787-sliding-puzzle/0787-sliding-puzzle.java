import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        
        // Convert the 2D board to a string
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }
        
        // Define the valid moves for each position
        int[][] moves = {
            {1, 3},     // position 0
            {0, 2, 4},  // position 1
            {1, 5},     // position 2
            {0, 4},     // position 3
            {1, 3, 5},  // position 4
            {2, 4}      // position 5
        };
        
        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(start.toString());
        visited.add(start.toString());
        int steps = 0;
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return steps;
                }
                
                // Find the position of '0'
                int zeroPos = current.indexOf('0');
                
                // Try all valid moves for '0'
                for (int move : moves[zeroPos]) {
                    char[] chars = current.toCharArray();
                    // Swap '0' with the adjacent number
                    chars[zeroPos] = chars[move];
                    chars[move] = '0';
                    
                    String nextState = new String(chars);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            steps++;
        }
        
        // If the queue is exhausted, no solution exists
        return -1;
    }
}
