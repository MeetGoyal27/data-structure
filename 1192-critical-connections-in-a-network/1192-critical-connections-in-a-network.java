class Solution {
    int time = 0;
    int[] dt;
    int[] low;
    public void dfs(int src,int parent, List<List<Integer>> adj,boolean[] vis,List<List<Integer>> ans){
        vis[src] = true;
        time++;
        dt[src] = time;
        low[src] = time;
        for(int neighbour : adj.get(src)){
            if(!vis[neighbour]){
                dfs(neighbour,src,adj,vis,ans);
                low[src] = Math.min(low[src],low[neighbour]);
                if(dt[src] < low[neighbour]){
                    List<Integer> l = new ArrayList<>();
                    l.add(src);
                    l.add(neighbour);
                    ans.add(l);
                }
                
            }
            else if(vis[neighbour] == true && neighbour != parent){
                low[src] = Math.min(low[src],dt[neighbour]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dt = new int[n];
        low = new int[n];
        boolean[] vis = new boolean[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,-1,adj,vis,ans);
        return ans;
    }
}