import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] mat = new int[26][26];

        // Step 1: Build the transition matrix
        for (int i = 0; i < 26; i++) {
            int count = nums.get(i);
            for (int j = 1; j <= count; j++) {
                mat[i][(i + j) % 26] = (mat[i][(i + j) % 26] + 1) % MOD;
            }
        }

        // Step 2: Matrix exponentiation
        int[][] powerMat = matrixPower(mat, t);

        // Step 3: Build initial frequency vector
        long[] freq = new long[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 4: Multiply freq vector with matrix
        long[] finalFreq = new long[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                finalFreq[j] = (finalFreq[j] + freq[i] * powerMat[i][j]) % MOD;
            }
        }

        // Step 5: Sum all counts
        long total = 0;
        for (long count : finalFreq) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }

    private int[][] matrixPower(int[][] mat, int power) {
        int size = mat.length;
        int[][] result = new int[size][size];

        // Initialize result as identity matrix
        for (int i = 0; i < size; i++) result[i][i] = 1;

        while (power > 0) {
            if ((power & 1) == 1) result = multiplyMatrix(result, mat);
            mat = multiplyMatrix(mat, mat);
            power >>= 1;
        }

        return result;
    }

    private int[][] multiplyMatrix(int[][] a, int[][] b) {
        int size = a.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (a[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    result[i][j] = (int)((result[i][j] + 1L * a[i][k] * b[k][j]) % MOD);
                }
            }
        }

        return result;
    }
}
