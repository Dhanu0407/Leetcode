class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        return recur(expression,0,n-1);
    }
    public List<Integer> recur(String exp, int start, int end){
        List<Integer> result = new ArrayList<>();

        if(start==end){
            int num = exp.charAt(start)-'0';
            result.add(num);
            return result;
        }

        if(end-start==1 && Character.isDigit(exp.charAt(start))){
            // int num1 = exp.charAt(start)-'0';
            // int num2 = exp.charAt(end)-'0';

            int num = Integer.parseInt(exp.substring(start,end+1));
            result.add(num);
            return result;
        }

        for(int i=start; i<=end; i++){
            if(Character.isDigit(exp.charAt(i))){
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp,start,i-1);
            List<Integer> right = recur(exp,i+1,end);
            for(int l:left){
                for(int r:right){
                    if(op=='*'){
                        result.add(l*r);
                    }else if(op=='+'){
                        result.add(l+r);
                    }else{
                        result.add(l-r);
                    }
                }
            }
        }
        return result;
    }
}