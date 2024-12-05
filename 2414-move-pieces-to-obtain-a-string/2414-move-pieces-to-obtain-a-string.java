class Solution {
    public boolean canChange(String start, String target) {
        // Step 1: Remove '_' from both strings and compare if they match
        if (!start.replace("_", "").equals(target.replace("_", ""))) {
            return false;
        }

        // Step 2: Check movement constraints
        int n = start.length();
        int i = 0, j = 0; // Pointers for start and target

        while (i < n && j < n) {
            // Skip blanks in both strings
            while (i < n && start.charAt(i) == '_') i++;
            while (j < n && target.charAt(j) == '_') j++;

            // If both pointers reach the end, we're done
            if (i == n && j == n) return true;

            // If one pointer reaches the end but the other doesn't, return false
            if (i == n || j == n) return false;

            // The characters at the pointers must match
            if (start.charAt(i) != target.charAt(j)) return false;

            // Check the movement constraints
            if (start.charAt(i) == 'L' && i < j) return false; // 'L' cannot move right
            if (start.charAt(i) == 'R' && i > j) return false; // 'R' cannot move left

            // Move both pointers forward
            i++;
            j++;
        }

        return true;
    }
}
