class Solution {
    public String compressedString(String word) {
        StringBuilder SmallString = new StringBuilder();

        int counter = 0;

        while(counter < word.length()){
            char ch = word.charAt(counter);
            int chCount = 1;

            while(chCount+counter<word.length() && word.charAt(counter+chCount)==ch && chCount<9){
                chCount++;
            }
            SmallString.append(chCount).append(ch);

            counter+=chCount;
        }

        return SmallString.toString();
    }
}