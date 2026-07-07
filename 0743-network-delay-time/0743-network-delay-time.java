class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : times){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[]{k-1,0});
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1] = 0;
        while(pq.size()>0){
            int[] pair = pq.poll();
            int u = pair[0];
            int d = pair[1];
            for(int[] neighbour : adj.get(u)){
                int v = neighbour[0];
                int w = neighbour[1];
                if(dist[u]+w<dist[v]){
                    dist[v] = dist[u]+w;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        int ans = -1;
        for(int x : dist){
            ans = Math.max(x,ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}