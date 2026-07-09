class Solution {
    public boolean bfs(int src,int[] color,int[][] graph,Queue<Integer> q){
        q.offer(src);
        color[src] = 0;
        while(q.size()>0){
            int node = q.poll();
            for(int neighbour : graph[node]){
                if(color[neighbour] == -1){
                    color[neighbour] = 1 - color[node];
                    q.offer(neighbour);
                }
                else if(color[neighbour] != color[node]){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++){
            if(color[i] == -1){
                if(bfs(i,color,graph,q) == false){
                    return false;
                }
            }
        }
        return true;
    }
}