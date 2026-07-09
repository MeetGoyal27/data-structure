class Solution {
    public boolean bfs(int src,int[] color,ArrayList<ArrayList<Integer>> graph,Queue<Integer> q){
        q.offer(src);
        color[src] = 0;
        while(q.size()>0){
            int node = q.poll();
            for(int neighbour : graph.get(node)){
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
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : dislikes){
            int u = edge[0]-1;
            int v = edge[1]-1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.size()];
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