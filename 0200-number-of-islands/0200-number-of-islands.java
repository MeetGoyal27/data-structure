class Solution {
    public void dfs(int row,int col,boolean[][] vis,char[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }
        if(vis[row][col] == true){
            return;
        }
        vis[row][col] = true;
        dfs(row+1,col,vis,grid);
        dfs(row-1,col,vis,grid);
        dfs(row,col+1,vis,grid);
        dfs(row,col-1,vis,grid);
    }
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    dfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
}