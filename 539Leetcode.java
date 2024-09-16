class Solution{
    public int findMinDifference(List<String> timePoints){
        boolean[] hours  = new boolean[1440];

        for(String num : timePoints){
            int h = Integer.parseInt(num.substring(0,2));
            int m = Integer.parseInt(num.substring(3,5));

            int mins = h*60+m;

            if(hours[mins]) return 0;

            hours[mins] = true;
        }

        int prev = -1;
        int firstVal = -1;
        int mindifference = Integer.MAX_VALUE;

        for(int curr=0; curr<1440; curr++){
          if(hours[curr]){
            if(prev==-1){
                prev = curr;
                firstVal = curr;
            }else{
                mindifference = Math.min(mindifference , curr-prev);
                prev = curr;
            }
          }  
        }
        if(prev!=-1){
            mindifference = Math.min(mindifference,1440+firstVal-prev);
        }

        return mindifference;
    }
}