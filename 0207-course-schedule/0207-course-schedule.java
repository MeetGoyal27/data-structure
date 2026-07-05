class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            list.get(v).add(u);
        }
        ArrayList<Integer> l = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int[] x : prerequisites){
            int u = x[0];
            int v = x[1];
            indegree[u]++;
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        while(q.size()>0){
            int node = q.poll();
            l.add(node);
            for(int neighbour : list.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        if(l.size() == numCourses){
            return true;
        }
        return false;
    }
}