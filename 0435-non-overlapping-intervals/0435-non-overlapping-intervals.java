class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int ans = 0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int[] first = intervals[0];
        for(int i=1;i<n;i++){
            int ff = first[0];
            int fs = first[1];
            int[] second = intervals[i];
            int sf = second[0];
            int ss = second[1];
            if(sf >= fs){
                first = second;
            }
            else{
                ans++;
            }
        }
        return ans;
        
    }
}