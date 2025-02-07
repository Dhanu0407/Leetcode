import java.util.*;

class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballColors = new HashMap<>();
        Map<Integer, Integer> colorFrequency = new HashMap<>();
        int[] result = new int[queries.length];
        int distinctColors = 0;

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballColors.containsKey(ball)) {
                int oldColor = ballColors.get(ball);
                colorFrequency.put(oldColor, colorFrequency.get(oldColor) - 1);
                if (colorFrequency.get(oldColor) == 0) {
                    distinctColors--;
                    colorFrequency.remove(oldColor);
                }
            }

            ballColors.put(ball, color);
            colorFrequency.put(color, colorFrequency.getOrDefault(color, 0) + 1);

            if (colorFrequency.get(color) == 1) {
                distinctColors++;
            }

            result[i] = distinctColors;
        }

        return result;
    }
}
