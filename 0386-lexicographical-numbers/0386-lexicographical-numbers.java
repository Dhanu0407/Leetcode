class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;
        for (int i = 0; i < n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10; // Go deeper
            } else {
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10; // Backtrack
                }
                curr++; // Go to next sibling
            }
        }
        return result;
    }
}
