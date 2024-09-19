
class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask state
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Initialize with bitmask 0 at index -1
        
        int maxLength = 0;
        int bitmask = 0; // To track the state of vowels
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Update bitmask when a vowel is encountered
            if (c == 'a') {
                bitmask ^= (1 << 0); // Toggle the first bit
            } else if (c == 'e') {
                bitmask ^= (1 << 1); // Toggle the second bit
            } else if (c == 'i') {
                bitmask ^= (1 << 2); // Toggle the third bit
            } else if (c == 'o') {
                bitmask ^= (1 << 3); // Toggle the fourth bit
            } else if (c == 'u') {
                bitmask ^= (1 << 4); // Toggle the fifth bit
            }
            
            // Check if this bitmask state has been seen before
            if (map.containsKey(bitmask)) {
                // Calculate the length of the substring
                maxLength = Math.max(maxLength, i - map.get(bitmask));
            } else {
                // Store the first occurrence of this bitmask
                map.put(bitmask, i);
            }
        }
        
        return maxLength;
    }
}
