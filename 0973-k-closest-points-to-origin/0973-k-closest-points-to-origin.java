class Solution {
    public int[][] kClosest(int[][] points, int k) {
        List<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<points.length;i++){
            int[] arr = points[i];
            int x = arr[0];
            int y = arr[1];
            int d = (x*x) + (y*y);
            pq.offer(new int[]{d,i});
        }
        for(int i=0;i<k;i++){
            int[] nums = pq.poll();
            int dist = nums[0];
            int idx = nums[1];
            list.add(points[idx]);
        }
        int[][] finl = new int[list.size()][];
        for(int i=0;i<list.size();i++){
            finl[i] = list.get(i);
        }
        return finl;
    }
}