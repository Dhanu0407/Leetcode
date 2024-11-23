class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char result[][] = new char[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                result[i][j] = box[j][i];
            }
        }
    

        for(int i=0; i<n; i++){
            reverseRow(result[i]);
        }

        for(int j=0; j<m; j++){
            int space = n-1;

            for(int i=n-1; i>=0; i--){
                if(result[i][j]=='*'){
                    space = i-1;
                    continue;
                }


                if(result[i][j]=='#'){
                    result[i][j]='.';
                    result[space][j]='#';
                    space--;
                }
            }
        }
        return result;
        
    }

    private void reverseRow(char[] row){
        int left = 0, right = row.length-1;

        while(left<right){
            char temp = row[left];
            row[left]=row[right];
            row[right]=temp;
            left++;
            right--;
        }
    }
}