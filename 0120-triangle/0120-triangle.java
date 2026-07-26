class Solution {
    public int recur(int row,int col,List<List<Integer>> triangle,int[][] dp,boolean[][] vis){
        if(row == triangle.size()-1){
            dp[row][col] = triangle.get(row).get(col);
            return dp[row][col];
        }
        if(vis[row][col] == true){
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + recur(row+1,col+1,triangle,dp,vis);
        int right = triangle.get(row).get(col) + recur(row+1,col,triangle,dp,vis);
        dp[row][col] = Math.min(down,right);
        vis[row][col] = true;
        return dp[row][col]; 
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        boolean[][] vis = new boolean[m][m];
        return recur(0,0,triangle,dp,vis);
    }
}