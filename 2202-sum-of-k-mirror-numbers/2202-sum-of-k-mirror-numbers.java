class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            // Generate palindromes with 'length' digits
            for (long num : generatePalindromes(length)) {
                String baseK = toBaseK(num, k);
                if (isPalindrome(baseK)) {
                    sum += num;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }

        return sum;
    }

    private List<Long> generatePalindromes(int length) {
        List<Long> list = new ArrayList<>();
        
        // Odd length palindromes
        int start = (int)Math.pow(10, (length - 1) / 2);
        int end = (int)Math.pow(10, (length + 1) / 2);

        for (int i = start; i < end; i++) {
            String s = Integer.toString(i);
            String rev = new StringBuilder(s.substring(0, length / 2)).reverse().toString();
            String full = s + rev;
            list.add(Long.parseLong(full));
        }

        return list;
    }

    private String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
