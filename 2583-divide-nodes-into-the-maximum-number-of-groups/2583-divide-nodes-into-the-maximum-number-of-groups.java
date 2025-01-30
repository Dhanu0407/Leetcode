import java.util.*;

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        int maxGroups = 0;

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                List<Integer> component = new ArrayList<>();
                if (!isBipartite(i, graph, color, component)) return -1;
                maxGroups += maxBFSDepth(graph, component);
            }
        }
        
        return maxGroups;
    }

    private boolean isBipartite(int node, List<List<Integer>> graph, int[] color, List<Integer> component) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        color[node] = 0;  // Start coloring with 0
        component.add(node);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : graph.get(cur)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[cur];
                    queue.add(neighbor);
                    component.add(neighbor);
                } else if (color[neighbor] == color[cur]) {
                    return false;  // Found an odd-length cycle → Not bipartite
                }
            }
        }
        return true;
    }

    private int maxBFSDepth(List<List<Integer>> graph, List<Integer> component) {
        int maxDepth = 0;
        for (int node : component) {
            maxDepth = Math.max(maxDepth, bfsDepth(graph, node));
        }
        return maxDepth;
    }

    private int bfsDepth(List<List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int neighbor : graph.get(cur)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        return depth;
    }
}
