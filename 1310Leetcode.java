class Solution{
  public int[] xorQueries(int[] arr, int[][] queries){
    int[] pre = new int[arr.length];
    pre[0] = arr[0];
    int xor = pre[0];

    for(int i=1; i<arr.length; i++){
     xor^=arr[i];
     pre[i] = xor;
    }

    int[] ans = new int[queries.length];

    for(int i=0; i<queries.length; i++){
        int right = queries[i][1];
        int left = queries[i][0];
        ans[i] = pre[right];

        if(left>0){
            ans[i]^=pre[left-1];
        }
    }
    return ans;
  }
}