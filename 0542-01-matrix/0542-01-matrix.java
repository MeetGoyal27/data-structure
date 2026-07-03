class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        Queue<int[]> q = new LinkedList<>();
        int n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    q.offer(new int[]{i,j});
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }    
        while(q.size()>0){
            int[] x = q.poll();
            int r = x[0];
            int c = x[1];
            int[][] neighbours = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};
            for(int[] neighbour : neighbours){
                int nr = neighbour[0];
                int nc = neighbour[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n || ans[nr][nc] != -1){
                    continue;
                }
                ans[nr][nc] = ans[r][c]+1;
                q.offer(new int[]{nr,nc});
            }
        }
        return ans;    
    }
}