import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;
        
        // Graph representation using adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0], v = road[1], t = road[2];
            graph.get(u).add(new int[]{v, t});
            graph.get(v).add(new int[]{u, t});
        }

        // Min-Heap Priority Queue (Dijkstra)
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0});  // (node, time)
        
        // Distance and Ways Arrays
        long[] minTime = new long[n];
        Arrays.fill(minTime, Long.MAX_VALUE);
        minTime[0] = 0;
        
        int[] ways = new int[n];
        ways[0] = 1;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long time = curr[1];

            if (time > minTime[node]) continue; // Skip outdated paths
            
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long newTime = time + neighbor[1];

                if (newTime < minTime[nextNode]) {
                    minTime[nextNode] = newTime;
                    ways[nextNode] = ways[node];  // Reset ways count
                    pq.offer(new long[]{nextNode, newTime});
                } else if (newTime == minTime[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return ways[n - 1];
    }
}
