class Solution {
    int low,high,zero,one;
    final int M = 1_000_000_007;
    int dp[];
    private int solve(int len)
    {
        if(len >high)
        {
            return 0;
        }
        if(dp[len] !=-1)
        {
            return dp[len];
        }
        boolean addOne=false;
        if(len >= low && len <= high)
        {
            addOne =true;

        }
        int takeZero= solve(len +zero);
        int takeOne= solve(len +one);

        dp[len]= (addOne?1:0)+ takeOne +takeZero;
       dp[len] %=M;
        return dp[len];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.low=low;
        this.high=high;
        this.one=one;
        this.zero=zero;
        dp=new int[high+1];
        Arrays.fill(dp,-1);
        return solve(0);
        
    }
}