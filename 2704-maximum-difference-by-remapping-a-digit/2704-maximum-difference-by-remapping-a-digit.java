class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        
        // Get max number by replacing one digit with 9
        int maxVal = getModifiedValue(numStr, true);
        
        // Get min number by replacing one digit with 0
        int minVal = getModifiedValue(numStr, false);
        
        return maxVal - minVal;
    }

    private int getModifiedValue(String numStr, boolean findMax) {
        char[] digits = numStr.toCharArray();
        char targetDigit = ' ';
        char replaceWith = findMax ? '9' : '0';

        for (char c : digits) {
            if (findMax && c != '9') {
                targetDigit = c;
                break;
            } else if (!findMax && c != '0') {
                targetDigit = c;
                break;
            }
        }

        // If all digits are already 9 or 0, no change needed
        if (targetDigit == ' ') return Integer.parseInt(numStr);

        // Replace all occurrences
        StringBuilder sb = new StringBuilder();
        for (char c : digits) {
            if (c == targetDigit) {
                sb.append(replaceWith);
            } else {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
