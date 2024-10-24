class Solution {
    public int myAtoi(String s) {
        // Constants for 32-bit signed integer range
        int INT_MAX = 2147483647; // 2^31 - 1
        int INT_MIN = -2147483648; // -2^31

        // Step 1: Remove leading whitespaces
        s = s.trim();
        
        // Edge case: if the string is empty after trimming
        if (s.length() == 0) {
            return 0;
        }

        // Step 2: Determine the sign
        int sign = 1;
        int index = 0;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }

        // Step 3: Convert the number
        int result = 0;
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            if (!Character.isDigit(currentChar)) {
                break;
            }

            int digit = currentChar - '0';

            // Step 4: Check for overflow/underflow before updating the result
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
            index++;
        }

        // Apply the sign and return the result
        return result * sign;
    }
}
