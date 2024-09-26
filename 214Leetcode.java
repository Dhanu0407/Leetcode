class Solution {
    public String shortestPalindrome(String s) {
       
       if (s == null || s.length() == 0) {
           return s;
       }

       
       String rev = new StringBuilder(s).reverse().toString();
       String combined = s + "#" + rev;
       
       int[] lps = computeLPS(combined);
       int Length = lps[lps.length - 1];

       
       String toAdd = rev.substring(0, rev.length() - Length);
       return toAdd + s;
   }

   private int[] computeLPS(String s) {
       int[] lps = new int[s.length()];
       int length = 0; 
       int i = 1;
       
       while (i < s.length()) {
           if (s.charAt(i) == s.charAt(length)) {
               length++;
               lps[i] = length;
               i++;
           } else {
               if (length != 0) {
                   length = lps[length - 1];
               } else {
                   lps[i] = 0;
                   i++;
               }
           }
       }
       return lps;
   }
}