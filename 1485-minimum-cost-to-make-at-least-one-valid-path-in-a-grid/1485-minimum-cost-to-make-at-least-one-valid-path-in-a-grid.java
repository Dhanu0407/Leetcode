import java.util.*;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        deque.offerFirst(new int[]{0, 0, 0}); // {row, col, current_cost}

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1], currentCost = current[2];

            if (currentCost > cost[x][y]) continue;

            for (int i = 0; i < 4; i++) {
                int newX = x + directions[i][0];
                int newY = y + directions[i][1];
                int newCost = currentCost + (grid[x][y] == i + 1 ? 0 : 1);

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && newCost < cost[newX][newY]) {
                    cost[newX][newY] = newCost;
                    if (grid[x][y] == i + 1) {
                        deque.offerFirst(new int[]{newX, newY, newCost});
                    } else {
                        deque.offerLast(new int[]{newX, newY, newCost});
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
