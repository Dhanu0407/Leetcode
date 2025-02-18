class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the pattern
        for (int i = 0; i <= n; i++) {
            // Push the current index + 1 into the stack
            stack.push(i + 1);
            
            // If it's the last iteration or 'I' is encountered, pop all elements from the stack
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}
