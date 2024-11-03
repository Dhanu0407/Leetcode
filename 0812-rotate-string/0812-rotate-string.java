class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length()!=goal.length()){
            return false;
        }

        String S2 = s+s;

        return S2.contains(goal);       
    }
}