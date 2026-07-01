class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count = 0;
        boolean vis[] = new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                List<Integer> component = new ArrayList<>();
                dfs(graph, vis, i, component);
                int nodes = component.size();
                int totaledges = 0;
                for(int node: component){
                    totaledges += graph.get(node).size();
                }

                totaledges/=2;
                if(totaledges == nodes*(nodes-1)/2){
                    count++;
                }
            }
        }
    return count;
    }
    public static void dfs(List<List<Integer>> graph, boolean vis[], int src, List<Integer> component){
        vis[src] = true;
        component.add(src);
        for(int nbor: graph.get(src)){
            if(!vis[nbor]){
                dfs(graph, vis, nbor, component);
            }
        }
    }
}