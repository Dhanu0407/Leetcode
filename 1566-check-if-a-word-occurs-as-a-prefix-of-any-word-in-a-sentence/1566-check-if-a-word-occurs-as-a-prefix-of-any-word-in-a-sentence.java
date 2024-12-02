class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Iterate through the words with their indices
        for (int i = 0; i < words.length; i++) {
            // Check if the searchWord is a prefix of the current word
            if (words[i].startsWith(searchWord)) {
                // Return the 1-based index
                return i + 1;
            }
        }
        
        // If no prefix match is found, return -1
        return -1;
    }
}
