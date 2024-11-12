

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Step 1: Sort items by price and beauty
        Arrays.sort(items, (a, b) -> a[0] - b[0]);  // Sort items by price
        
        // Step 2: Create a map of maximum beauty up to each unique price
        Map<Integer, Integer> priceToMaxBeauty = new HashMap<>();
        int maxBeauty = 0;
        
        for (int[] item : items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            priceToMaxBeauty.put(item[0], maxBeauty); // Update max beauty at this price
        }
        
        // Step 3: Create a sorted array of unique prices with cumulative max beauty
        int[] sortedPrices = new int[priceToMaxBeauty.size()];
        int index = 0;
        for (int price : priceToMaxBeauty.keySet()) {
            sortedPrices[index++] = price;
        }
        Arrays.sort(sortedPrices);
        
        // Step 4: Answer each query using binary search
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            
            // Binary search for the rightmost price <= query
            int pos = Arrays.binarySearch(sortedPrices, query);
            if (pos < 0) {
                pos = -pos - 2;  // If not found, adjust to find nearest lower price
            }
            
            // If a valid price is found, get the max beauty; otherwise, result is 0
            if (pos >= 0) {
                result[i] = priceToMaxBeauty.get(sortedPrices[pos]);
            } else {
                result[i] = 0;
            }
        }
        
        return result;
    }
}
