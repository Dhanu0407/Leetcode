class Solution{
    public String[] uncommonFromSentences(String s1, String s2){
        HashMap<String, Integer> freq = new HashMap<>();

        for(String word:s1.split(" ")){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        for(String word:s2.split(" ")){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }

        ArrayList<String> lst = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : freq.entrySet()){
            if(entry.getValue()==1){
                lst.add(entry.getKey());
            }
        }
        String arr[] = new String[lst.size()];
        lst.toArray(arr);

        return arr;
    }
}