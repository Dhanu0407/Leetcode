class Solution {
    int maxCount = 0;
    public int maxUniqueSplit(String s) {
        maxCount=0;
        HashSet<String> uniqueSet = new HashSet<>();
        backtrack(s,uniqueSet,0);
        return maxCount;
    }
    public void backtrack(String s, HashSet<String>uniqueSet,int index){

        if(index==s.length()){
            maxCount=Math.max(maxCount,uniqueSet.size());
            return;
        }

        for(int i=index;i<s.length();i++){
            String subS = s.substring(index,i+1);
            if(!uniqueSet.contains(subS)){
                  uniqueSet.add(subS);
                  backtrack(s,uniqueSet,i+1);
                  uniqueSet.remove(subS);
            }
        }
    }
}