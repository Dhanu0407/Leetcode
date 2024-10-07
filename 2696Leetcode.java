
//Approach -I beats - 85.00%
class Solution{
    public int minLength(String s){
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            if(ch=='B' && st.peek()=='A'){
                st.pop();
            }else if(ch=='D' && st.peek()=='C'){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        return st.size();
    }
}
//Approach -II beats - 97.04%

class Solution{
    public int minLength(String s){
char str[] = s.toCharArray();
  int write = 0;

        for(int read=0; read<s.length(); read++){
         if(write==0){
            str[write]=str[read];
            write++;
            continue;
         }
         if(str[read]=='B' && str[write-1]=='A'){
            write--;
         }else if(str[read]=='D' && str[write-1]=='C'){
            write--;
         }else{
            str[write]=str[read];
            write++;
         }
        }
        return write;
    }
}