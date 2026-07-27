class Solution {
    public static boolean recur(int idx,int currSum,int target,int[] arr,Boolean[][] dp){
        if(currSum == target){
            dp[idx][currSum] = true;
            return true;
        }
        if(currSum>target){
            return false;
        }
        if(idx == arr.length){
            dp[idx][currSum] = false;
            return false;
        }
        if(dp[idx][currSum] != null){
            return dp[idx][currSum];
        }
        boolean pick = recur(idx+1,currSum+arr[idx],target,arr,dp);
        boolean noPick = recur(idx+1,currSum,target,arr,dp);
        dp[idx][currSum] = pick || noPick;
        return pick || noPick;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x : nums){
            sum += x;
        }
        if(sum%2 != 0){
            return false;
        }
        int target = sum/2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n+1][target+1];
        return recur(0,0,target,nums,dp);
        
    }
}