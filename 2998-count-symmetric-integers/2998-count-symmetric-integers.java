class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        for (int num = low; num <= high; num++) {
            String str = Integer.toString(num);
            int len = str.length();
            
            if (len % 2 != 0) {
                continue; // skip numbers with odd number of digits
            }
            
            int half = len / 2;
            int sum1 = 0, sum2 = 0;
            
            for (int i = 0; i < half; i++) {
                sum1 += str.charAt(i) - '0'; // sum of first half digits
            }
            
            for (int i = half; i < len; i++) {
                sum2 += str.charAt(i) - '0'; // sum of second half digits
            }
            
            if (sum1 == sum2) {
                count++;
            }
        }
        
        return count;
    }
}
