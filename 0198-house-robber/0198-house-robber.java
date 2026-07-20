class Solution {
    public int recur(int idx,int[] nums,int[] dp){
        if(idx == nums.length-1){
            dp[idx] =  nums[idx];
            return dp[idx];
        }
        if(idx == nums.length){
            dp[idx] = 0;
            return dp[idx];
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = nums[idx] + recur(idx+2,nums,dp);
        int noPick = recur(idx+1,nums,dp);
        dp[idx] =  Math.max(pick,noPick);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        recur(0,nums,dp);
        return dp[0];
    }
}