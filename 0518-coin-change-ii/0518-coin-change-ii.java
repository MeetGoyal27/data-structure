class Solution {
    public int recur(int idx,int curr,int target,int[] arr,int[][] dp){
        if(curr == target){
            return 1;
        }
        if(curr > target || idx == arr.length){
            return 0;
        }
        if(dp[idx][curr] != -1){
            return dp[idx][curr];
        }
        int t = recur(idx,curr+arr[idx],target,arr,dp);
        int n = recur(idx+1,curr,target,arr,dp);
        dp[idx][curr] = t+n;
        return dp[idx][curr];
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,amount,coins,dp);
    }
}