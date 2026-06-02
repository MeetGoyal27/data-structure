class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int count = 0;
        int n = intervals.length;
        int first[] = intervals[0];
        for(int i=1;i<n;i++){
            int ff = first[0];
            int fs = first[1];
            int[] second = intervals[i];
            int sf = second[0];
            int ss = second[1];
            if(sf < fs){
                count++;
            }
            else{
                first[1] = second[1];
            }
        }
        return count;
        
    }
}