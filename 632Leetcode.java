class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k=nums.size();
        int[] indices=new int[k];
        int[] resultRange={-1000000,1000000};
        int minEl=Integer.MAX_VALUE;
        int maxEl=Integer.MIN_VALUE;
        int minElListIdx=0;
        while(true)
        {
            minEl=Integer.MAX_VALUE;
            maxEl=Integer.MIN_VALUE;
            for(int i=0;i<k;i++)
            {
                int listIdx=i;
                int elIdx=indices[i];
                int element=nums.get(listIdx).get(elIdx);
                if(element <minEl)
                {
                    minEl=element;
                    minElListIdx=listIdx;
                }
                maxEl=Math.max(maxEl,element);
            }
            if(maxEl-minEl < resultRange[1]-resultRange[0])
            {
                resultRange[0]=minEl;
                resultRange[1]=maxEl;
            }
            int nextIndex=indices[minElListIdx]+1;
            if(nextIndex >= nums.get(minElListIdx).size())
            {
                break;
            }
            indices[minElListIdx]=nextIndex;
        }
        return resultRange;
        
    }
}