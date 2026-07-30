class Solution {
    public int recur(int i,int j,String s1,String s2,int[][] dp){
        if(i==s1.length() || j==s2.length()){
            dp[i][j] = 0;
            return 0;
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = 1+recur(i+1,j+1,s1,s2,dp);
            return dp[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        else{
            dp[i][j] = Math.max(recur(i+1,j,s1,s2,dp),recur(i,j+1,s1,s2,dp));
            return dp[i][j];
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,text1,text2,dp);
    }
}