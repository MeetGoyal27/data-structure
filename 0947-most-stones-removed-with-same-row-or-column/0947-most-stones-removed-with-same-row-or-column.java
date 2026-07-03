class Solution {
    public void dfs(int src, List<List<Integer>> list,boolean[] vis){
        vis[src] = true;
        for(int neig : list.get(src)){
            if(!vis[neig]){
                dfs(neig,list,vis);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
          for(int j = i+1;j<n;j++){
            if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                list.get(i).add(j);
                list.get(j).add(i);
            }
          }
        }
        int components = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
              dfs(i,list,vis);
              components++;
            }
        }
        return n-components;

    }
}