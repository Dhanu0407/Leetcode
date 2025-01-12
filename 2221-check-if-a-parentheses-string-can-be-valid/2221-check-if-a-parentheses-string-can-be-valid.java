class Solution {
    public boolean canBeValid(String s, String locked) {
        // If the length of the string is odd, it cannot be valid
        if (s.length() % 2 != 0) return false;

        // First pass: Left to right
        int openCount = 0, freeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                freeCount++; // Count of indices that can be changed
            } else if (s.charAt(i) == '(') {
                openCount++;
            } else {
                // Closing parenthesis ')'
                if (openCount > 0) {
                    openCount--;
                } else if (freeCount > 0) {
                    freeCount--;
                } else {
                    return false; // No way to balance this closing parenthesis
                }
            }
        }

        // Second pass: Right to left
        int closeCount = 0;
        freeCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                freeCount++; // Count of indices that can be changed
            } else if (s.charAt(i) == ')') {
                closeCount++;
            } else {
                // Opening parenthesis '('
                if (closeCount > 0) {
                    closeCount--;
                } else if (freeCount > 0) {
                    freeCount--;
                } else {
                    return false; // No way to balance this opening parenthesis
                }
            }
        }

        return true;
    }
}
