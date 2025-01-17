class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        
        // Compute the XOR of all elements in derived
        for (int num : derived) {
            xorSum ^= num;
        }
        
        // If the total XOR is 0, a valid original array exists
        return xorSum == 0;
    }
}
