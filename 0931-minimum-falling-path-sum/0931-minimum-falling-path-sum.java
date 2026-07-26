class Solution {
    public int recur(int row,int col,int[][] mat,int[][] dp,boolean[][] vis){
        if(col<0){
            return Integer.MAX_VALUE;
        }
        if(col == mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(row == mat.length-1){
            dp[row][col] = mat[row][col];
            return dp[row][col];
        }
        if(vis[row][col] == true){
            return dp[row][col];
        }
        int down = recur(row+1,col,mat,dp,vis);
        int dl = recur(row+1,col-1,mat,dp,vis);
        int dr = recur(row+1,col+1,mat,dp,vis);
        vis[row][col] = true;
        dp[row][col] = mat[row][col] + Math.min(down,Math.min(dl,dr));
        return dp[row][col];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<n;i++){
            ans = Math.min(ans,recur(0,i,matrix,dp,vis));
        }
        return ans;
        
    }
}