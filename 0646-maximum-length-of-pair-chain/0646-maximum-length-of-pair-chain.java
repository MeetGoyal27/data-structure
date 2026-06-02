class Solution {
    public int findLongestChain(int[][] pairs) {
        int count = 1;
        Arrays.sort(pairs,(a,b)->Integer.compare(a[1],b[1]));
        int n = pairs.length;
        int[] first = pairs[0];
        for(int i=1;i<n;i++){
            int ff = first[0];
            int fs = first[1];
            int[] second = pairs[i];
            int sf = second[0];
            int ss = second[1];
            if(fs < sf){
                count++;
                first[1] = second[1];
            }
        }
        return count;
        
    }
}