class Solution {
    public int recur(int row,int col,int m,int n,int[][] mat,int[][] dp){
        if(row == m || col == n){
            dp[row][col] = 100000;
            return 100000;
        }
        if(row==m-1 && col==n-1){
            dp[row][col] = mat[row][col];
            return dp[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int min = 0;
        int right = mat[row][col] + recur(row,col+1,m,n,mat,dp);
        int down = mat[row][col] + recur(row+1,col,m,n,mat,dp);
        dp[row][col] = Math.min(right,down);
        return dp[row][col];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,m,n,grid,dp);
    }
}