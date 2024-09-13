class Solution {
    public int[][] generateMatrix(int n) {
      int spiral[][] = new int[n][n];

      int count = 1;
      int top = 0, bottom = n-1, left = 0, right = n-1;
      while(top<=bottom && left<=right){
        for(int col=left; col<=right; col++){
            spiral[top][col] = count;
            count++;
        }top++;
         for(int col=top; col<=bottom; col++){
            spiral[col][right] = count;
            count++;
        }right--;
         if(top<=bottom){
             for(int col=right; col>=left; col--){
            spiral[bottom][col] = count;
            count++;
             }bottom--;
         }
          if(left<=right){
            for(int col=bottom; col>=top; col--){
            spiral[col][left] = count;
            count++;
        }left++;
         
          }
         
      }
      return spiral; 
    }
}