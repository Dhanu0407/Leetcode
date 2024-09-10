class Solution{
    public int[][] spiralMatrix(int m, int n, ListNode head){
        int[][] spiral = new int[m][n];

        for(int i=0; i<m; i++){
            Arrays.fill(spiral[i],-1);
        }
      int top=0, left = 0, right = n-1, bottom = m-1;

      while(head!=null){
        for(int col = left; col<=right; col++){
            if(head==null)break;
            spiral[top][col] = head.val;
            head=head.next;
        }top++;

        for(int col=top; col<=bottom; col++){
            if(head==null)break;
            spiral[col][right]= head;
            head=head.next;
        }right--;

        for(int col=right; col>=left; col--){
            if(head==null)break;
            spiral[bottom][col] = head.val;
            head = head.next;
        }bottom--;

        for(int col=bottom; col>=top; col--){
            if(head==null)break;
            spiral[col][left] = head.val;
            head = head.next;
        }left++;
      }
      return spiral;
    }
}