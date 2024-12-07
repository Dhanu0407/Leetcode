class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
       int low=1,high=Integer.MAX_VALUE,result=high;
       while(low<high){
        int mid = low+(high-low)/2;
        if(isFeasible(nums,maxOperations,mid)){
            result=mid;
            high=mid;
        }else{
            low=mid+1;
        }
       } 
    
    return result;
}
private boolean isFeasible(int[] nums, int maxOperations,int penalty){
    int operations = 0;

    for(int num:nums){
        operations+=(num-1)/penalty;
        if(operations>maxOperations){
            return false;
        }
    }
    return true;
}
}