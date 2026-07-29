class Solution {
    public int recur(int idx,int curr,int target,int[] arr,int[][] dp){
        if(curr == target){
            dp[idx][curr] = 1;
            return 1;
        }
        if(idx == arr.length){
            dp[idx][curr] = 0;
            return 0;
        }
        if(curr > target){
            return 0;
        }
        if(dp[idx][curr] != -1){
            return dp[idx][curr];
        }
        int pick = recur(idx,curr+arr[idx],target,arr,dp);
        int noPick = recur(idx+1,curr,target,arr,dp);
        dp[idx][curr] = pick + noPick;
        return dp[idx][curr];
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,0,amount,coins,dp);
    }
}