import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        // Min-Heap to process the smallest cell values first
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Sorting queries while keeping track of original indices
        int[][] sortedQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int count = 0;  // Number of reachable cells
        int maxValue = 0; // Max grid value we have processed

        for (int[] query : sortedQueries) {
            int q = query[0], index = query[1];

            // Expand reachable cells until we hit a cell >= query value
            while (!pq.isEmpty() && pq.peek()[0] < q) {
                int[] cell = pq.poll();
                int val = cell[0], x = cell[1], y = cell[2];
                count++;  // Increase count of reachable cells

                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        pq.offer(new int[]{grid[nx][ny], nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }

            // Store result for this query
            result[index] = count;
        }

        return result;
    }
}
