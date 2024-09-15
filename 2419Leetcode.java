class Solution{
    public int longestSubarray(int[] nums){

        int max = Integer.MIN_VALUE;

        for(int num:nums){
            if(max<num){
                max=num;
            }
        }
        int longest = 0;
        int current = 0;

        for(int num:nums){
          if(num==max){
            current++;
          }else{
            longest = Math.max(longest,current);
            current = 0;
          }  
        }
        return Math.max(longest,current);
    }
}