class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] time : times){
            int u = time[0]-1;
            int v = time[1]-1;
            int w = time[2];
           list.get(u).add(new int[]{v,w});
        }
       int[] ans = new int[n];
       PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
        public int compare(int[] p1,int[] p2){
            return p1[1] - p2[1];
        }
       });
       q.add(new int[]{k-1,0});
       Arrays.fill(ans,Integer.MAX_VALUE);
       ans[k-1] = 0;
       while(q.size()>0){
          int[] temp = q.poll();
          int u = temp[0];
          int d = temp[1];
          for(int[] neighbour : list.get(u)){
             int v = neighbour[0];
             int w = neighbour[1];
             if(ans[u] + w < ans[v]){
                ans[v] = ans[u] + w;
                q.offer(new int[]{v,ans[v]});
             }
          }
       }
       int res = Integer.MIN_VALUE;
       for(int i : ans){
        res = Math.max(i,res);
       }
       return (res == Integer.MAX_VALUE) ? -1 : res;
    }
}