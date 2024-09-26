class Solution {
    public int[] sumPrefixScores(String[] words) {
        // Initialize Trie
        Trie trie = new Trie();
        
        // Step 1: Add all words to the Trie
        for (String word : words) {
            trie.addWord(word);
        }

        // Step 2: Calculate the prefix score for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.findPrefixCount(words[i]);
        }

        return result;
    }
}

// Trie Node Class
class Node {
    Node[] child;
    int count;  // To store the frequency of the prefix ending at this node

    Node() {
        child = new Node[26]; // 26 letters for lowercase English alphabet
        count = 0;
    }
}

// Trie Class
class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    // Method to add a word to the Trie
    public void addWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Get the index of the character
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            temp.child[index].count++; // Increment the prefix count
            temp = temp.child[index];
        }
    }

    // Method to find the prefix score for a word
    public int findPrefixCount(String word) {
        Node temp = root;
        int totalScore = 0;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Get the index of the character
            totalScore += temp.child[index].count; // Add the count of the current prefix
            temp = temp.child[index];
        }
        return totalScore;
    }
}
