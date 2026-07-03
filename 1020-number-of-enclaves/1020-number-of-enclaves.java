class Solution {
    public void dfs(int row,int col,int[][] grid){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }
        grid[row][col] = 0;
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
        dfs(row,col+1,grid);
        dfs(row,col-1,grid);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && (grid[i][j] == 1)){
                    dfs(i,j,grid);
                }
            }
        }
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count; 
    }
}