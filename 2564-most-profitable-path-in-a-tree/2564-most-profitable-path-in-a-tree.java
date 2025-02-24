import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        // Build the tree
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        // Step 1: Find Bob's path to root (node 0)
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(bob, -1, 0, tree, bobTime);

        // Step 2: Find the most profitable path for Alice
        return findMaxProfit(0, -1, 0, 0, tree, bobTime, amount);
    }

    private boolean findBobPath(int node, int parent, int time, List<Integer>[] tree, int[] bobTime) {
        bobTime[node] = time;
        if (node == 0) return true; // Bob reached root

        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            if (findBobPath(neighbor, node, time + 1, tree, bobTime)) return true;
        }

        bobTime[node] = Integer.MAX_VALUE; // If not on Bob's path, reset
        return false;
    }

    private int findMaxProfit(int node, int parent, int time, int currProfit, List<Integer>[] tree, int[] bobTime, int[] amount) {
        // Calculate actual amount Alice gains at this node
        if (time < bobTime[node]) { 
            currProfit += amount[node]; // Alice arrives first, takes full amount
        } else if (time == bobTime[node]) {
            currProfit += amount[node] / 2; // Alice and Bob arrive at the same time, split the amount
        }

        // If leaf node, return profit
        boolean isLeaf = true;
        int maxProfit = Integer.MIN_VALUE;
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, findMaxProfit(neighbor, node, time + 1, currProfit, tree, bobTime, amount));
        }

        return isLeaf ? currProfit : maxProfit;
    }
}
