class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
         int max= values[0]+0;
        int result=Integer.MIN_VALUE;
        for(int j=1;j<n;j++)
        {
            result=Math.max(result, max + values[j]-j);
            max= Math.max(max,values[j]+j);
        }
          return result;
    }
}