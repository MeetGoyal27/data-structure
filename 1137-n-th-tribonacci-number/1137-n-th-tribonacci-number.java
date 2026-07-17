class Solution {
    public int recur(int n,int[] dp){
        if(n == 0 || n == 1){
            dp[n] = n;
            return dp[n];
        }
        if(n == 2){
            dp[n] = 1;
            return dp[n];
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = recur(n-1,dp) + recur(n-2,dp) + recur(n-3,dp);
        return dp[n];
    }
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        recur(n,dp);
        return dp[n];
    }
}