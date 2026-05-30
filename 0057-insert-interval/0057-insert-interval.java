class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> list1 = new ArrayList<>();
        int nf = newInterval[0];
        int ns = newInterval[1];
        int i=0;
        while(i<intervals.length){
            int[] second = intervals[i];
            int sf = second[0];
            int ss = second[1];
            if(nf > sf){
                list1.add(second);
                i++;
            }
            else{
                break;
            }
        }
        list1.add(newInterval);
        while(i<intervals.length){
            list1.add(intervals[i]);
            i++;
        }
        List<int[]> list = new ArrayList<>();
        int[] first = list1.get(0);
        int n = list1.size();
        for(int j=1;j<n;j++){
            int ff = first[0];
            int fs = first[1];
            int[] second = list1.get(j);
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