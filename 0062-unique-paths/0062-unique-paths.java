class Solution {
    public int recur(int row,int col,int m,int n,int[][] dp){
        if(row == m || col == n){
            dp[row][col] = 0;
            return 0;
        }
        if(row == m-1 && col == n-1){
            dp[row][col] = 1;
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int down = recur(row+1,col,m,n,dp);
        int right = recur(row,col+1,m,n,dp);
        dp[row][col] = down+right;
        return dp[row][col];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,m,n,dp);
        
    }
}