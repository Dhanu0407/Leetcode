public class Solution {
    public boolean isValid(String word) {
        // Check if the word has at least 3 characters
        if (word.length() < 3) {
            return false;
        }

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char ch : word.toCharArray()) {
            if (Character.isLetter(ch)) {
                // Convert to lowercase to simplify comparison
                ch = Character.toLowerCase(ch);

                // Check if character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    // Otherwise it's a consonant
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(ch)) {
                // If it's not a letter or digit, it's invalid
                return false;
            }
        }

        // Return true only if it contains at least one vowel and one consonant
        return hasVowel && hasConsonant;
    }
}
