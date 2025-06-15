class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);

        // Create a (maximize): replace first non-9 digit with 9
        char[] aArr = numStr.toCharArray();
        char toReplaceA = 0;
        for (char c : aArr) {
            if (c != '9') {
                toReplaceA = c;
                break;
            }
        }
        String aStr = numStr;
        if (toReplaceA != 0) {
            aStr = numStr.replace(toReplaceA, '9');
        }

        // Create b (minimize): replace first digit with 1 (if not 1)
        // Else, replace next non-0 and non-1 digit with 0
        char[] bArr = numStr.toCharArray();
        char toReplaceB = 0;
        if (bArr[0] != '1') {
            toReplaceB = bArr[0];
            numStr = numStr.replace(toReplaceB, '1');
        } else {
            for (int i = 1; i < bArr.length; i++) {
                if (bArr[i] != '0' && bArr[i] != '1') {
                    toReplaceB = bArr[i];
                    break;
                }
            }
            if (toReplaceB != 0) {
                numStr = numStr.replace(toReplaceB, '0');
            }
        }
        String bStr = numStr;

        int a = Integer.parseInt(aStr);
        int b = Integer.parseInt(bStr);
        return a - b;
    }
}
