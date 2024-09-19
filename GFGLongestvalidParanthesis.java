import java.util.Stack;

class Solution{
    static int maxLength(String S){
        Stack<Integer> st = new Stack<>();

        st.push(-1);
        int maxLength = 0;

        for(int i=0; i<S.length(); i++){
            char c = S.charAt(i);

            if(c=='('){
                st.push(i);
            }else{
                st.pop();

                if(st.isEmpty()){
                    st.push(i);
                }else{
                    int currentLength = i - st.peek();
                    maxLength = Math.max(maxLength , currentLength);
                }
            }
        }
        return maxLength;
    }
}