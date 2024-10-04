class Solution{
    public long dividePlayers(int[] skill){
        int n = skill.length;
        Arrays.sort(skill);

        int i = 0;
        int j = n-1;
        int sumAllow = skill[i]+skill[j];
        long res = 0;

        while(i<j){
            if(skill[i]+skill[j]!=sumAllow){
                return -1;
            }
            res += (long)(skill[i]*skill[j]);
            i++;
            j--;
        }
        return res;
    }
}