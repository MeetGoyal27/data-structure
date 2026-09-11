class Solution {
    public int recur(int idx,int prevIdx,int[] arr,int[][] dp){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][prevIdx+1] != -1){
            return dp[idx][prevIdx+1];
        }
        if(prevIdx == -1 || arr[idx] > arr[prevIdx]){
            int take = 1 + recur(idx+1,idx,arr,dp);
            int no = recur(idx+1,prevIdx,arr,dp);
            dp[idx][prevIdx+1] =  Math.max(take,no);
            return dp[idx][prevIdx+1];

        }
        else{
            dp[idx][prevIdx+1] =  recur(idx+1,prevIdx,arr,dp);
            return dp[idx][prevIdx+1];
        }
    }
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return recur(0,-1,nums,dp);
    }
}