class Solution {
    int[] parent = new int[26];

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // Initialize each character's parent to itself
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // Union characters in s1 and s2
        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Build result for baseStr
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            char smallest = (char)(find(c - 'a') + 'a');
            result.append(smallest);
        }

        return result.toString();
    }

    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by keeping the smaller character as the parent
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rootX < rootY) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }
}
