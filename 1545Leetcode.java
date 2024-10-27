class Solution{
    public char findKthBit(int n, int k){
        int len = (int)Math.pow(2,n)-1;
        return recur(len,k);
    }
    public char recur(int len,int k){
        if(len==1){
            return '0';
        }

        int half = len/2;
        int mid = half+1;

        if(k==mid){
            return '1';
        }else if(k<mid){
            return recur(half,k);
        }else{
            char ans = recur(half,1+len-k);
            return (ans=='0')?'1':'0';
        }
    }
}