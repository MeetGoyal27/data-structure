class Solution {
    public void dfs( ArrayList<ArrayList<Integer>> list,boolean[] vis,int src){
        vis[src] = true;
        for(int neighbour : list.get(src)){
            if(!vis[neighbour]){
                dfs(list,vis,neighbour);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = isConnected.length;
        for(int i=0;i<V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j && isConnected[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(list,vis,i);
                count++;
            }
        }
        return count;
    }
}