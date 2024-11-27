
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add initial roads (i -> i+1 with weight 1)
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(new int[]{i + 1, 1});
        }

        // Result array to store shortest paths after each query
        int[] result = new int[queries.length];

        // Process each query
        for (int k = 0; k < queries.length; k++) {
            int u = queries[k][0], v = queries[k][1];

            // Add the new road
            graph.get(u).add(new int[]{v, 1});

            // Compute shortest path from 0 to n-1 using Dijkstra's algorithm
            result[k] = dijkstra(0, n - 1, n, graph);
        }

        return result;
    }

    // Dijkstra's algorithm to find shortest path
    private int dijkstra(int start, int end, int n, List<List<int[]>> graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], currentDist = curr[1];

            if (node == end) return currentDist;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0], weight = neighbor[1];
                if (currentDist + weight < dist[nextNode]) {
                    dist[nextNode] = currentDist + weight;
                    pq.add(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist[end];
    }
}
