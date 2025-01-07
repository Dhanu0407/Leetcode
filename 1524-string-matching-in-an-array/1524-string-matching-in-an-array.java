import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Iterate through each word in the array
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Skip comparing the word with itself
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Move to the next word since it's already a substring
                }
            }
        }
        
        return result;
    }
}
