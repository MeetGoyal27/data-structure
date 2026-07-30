class Solution {
    public int recur(int idx1,int idx2,String s1,String s2,int[][] dp){
        if(idx1 == s1.length() || idx2 == s2.length()){
            dp[idx1][idx2] = 0;
            return 0;
        }
        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            dp[idx1][idx2] = 1 + recur(idx1+1,idx2+1,s1,s2,dp);
            return dp[idx1][idx2];
        }
        else{
            int first = recur(idx1,idx2+1,s1,s2,dp);
            int second = recur(idx1+1,idx2,s1,s2,dp);
            dp[idx1][idx2] = Math.max(first,second);
            return dp[idx1][idx2];
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