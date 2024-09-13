
class solution{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> spiral = new ArrayList<>();
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;

        while(top<=bottom && left<=right){
            for(int col = left; col<=right; col++){
                spiral.add(matrix[top][col]);
            }top++;

            for(int col = top; col<=bottom; col++){
                spiral.add(matrix[col][right]);
            }right--;

            if(top<=bottom){
                for(int col=right; col>=left; col--){
                    spiral.add(matrix[bottom][col]);
                }bottom--;
            }

            if(left<=right){
                for(int col=bottom; col>=top; col--){
                    spiral.add(matrix[col][left]);
                }left++;
            }
        }
        return spiral;

    }
}