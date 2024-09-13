class Solution{
  public int countConsistentStrings(String allowed, String[] words){
    boolean[] arr = new boolean[26];

    for(int i=0; i<allowed.length(); i++){
        char ch = allowed.charAt(i);
        int index = ch - 'a';
        arr[index] = true;
    }
    int consisCount = 0;

    for(String word : words){
        boolean isconst = true;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int index = ch - 'a';

            if(!arr[index]){
                isconst = false;
                break;
            }
        }
        if(isconst){
            consisCount++;
        }
    }
    return consisCount;
  }  
}