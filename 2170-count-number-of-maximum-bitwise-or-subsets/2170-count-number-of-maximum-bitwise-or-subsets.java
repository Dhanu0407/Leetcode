class Solution{
    public int countMaxOrSubsets(int[]nums){

        int finalTarget = 0;

        for(int num:nums){
            finalTarget |= num;
        }

        return subsetRecur(0,nums,0,finalTarget);
    }

    public static int subsetRecur(int index,int nums[],int currCount,int finalTarget){
        if(index==nums.length){
            return (currCount==finalTarget)?1:0;

        }
        int picked = subsetRecur(index+1, nums, currCount|nums[index], finalTarget);

        int noPicking=subsetRecur(index+1, nums, currCount, finalTarget);

        return picked+noPicking;
    }
}