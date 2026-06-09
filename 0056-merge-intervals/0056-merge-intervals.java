class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] first = intervals[0];
        for(int i=1;i<n;i++){
            int ff = first[0];
            int fs = first[1];
            int[] second = intervals[i];
            int sf = second[0];
            int ss = second[1];
            if(sf <= fs){
                first[0] = Math.min(ff,sf);
                first[1] = Math.max(fs,ss);
            }
            else{
                list.add(first);
                first = second;
            }
        }
        list.add(first);
        return list.toArray(new int[list.size()][2]);
        
    }
}