import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(n, new StringBuilder(), happyStrings);
        
        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }
    
    private void generateHappyStrings(int n, StringBuilder current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current.toString());
            return;
        }
        
        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.length() == 0 || current.charAt(current.length() - 1) != ch) {
                current.append(ch);
                generateHappyStrings(n, current, happyStrings);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
