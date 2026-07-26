class Solution {
    public int recur(int row,int col,int m,int n,int[][] mat,int[][] dp){
        if(row == m || col == n){
            dp[row][col] = 0;
            return dp[row][col];
        }
        if(mat[row][col] == 1){
            dp[row][col] = 0;
            return dp[row][col];
        }
        if(row == m-1 && col == n-1){
            dp[row][col] = 1;
            return dp[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        dp[row][col] = recur(row+1,col,m,n,mat,dp) + recur(row,col+1,m,n,mat,dp);
        return dp[row][col];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,m,n,obstacleGrid,dp);
    }
}