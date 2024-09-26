class Solution{
    public List<Integer> lexicalOrder(int n){
        List<Integer> res = new ArrayList<>();

        int curr = 1;

        for(int i=1; i<=n; i++){
            res.add(curr);
            if(curr*10<=n){
                curr*=10;
            }else{
                while(curr%10==9 || curr==n){
                    curr/=10;
                }
                curr+=1;
            }
        }
        return res;
    }
}