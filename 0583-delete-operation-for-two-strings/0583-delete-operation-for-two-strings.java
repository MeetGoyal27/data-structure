class Solution {
    public int recur(int i,int j,String a,String b,int[][] dp){
        if(i == a.length() || j == b.length()){
            dp[i][j] = 0;
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(a.charAt(i) == b.charAt(j)){
            dp[i][j] = 1+recur(i+1,j+1,a,b,dp);
            return dp[i][j];
        }
        else{
            int left = recur(i+1,j,a,b,dp);
            int right = recur(i,j+1,a,b,dp);
            dp[i][j] = Math.max(left,right);
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int lcs = recur(0,0,word1,word2,dp);
        return m+n-(2*lcs);
    }
}