class Solution {
    public int recur(int idx,int prev,int[][] arr,int[][] dp){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][prev+1] != -1){
            return dp[idx][prev+1];
        }
        int not = recur(idx+1,prev,arr,dp);
        int take = 0;
        if(prev == -1 || arr[idx][1] >= arr[prev][1]){
            take = arr[idx][1] + recur(idx+1,idx,arr,dp);
        }
        dp[idx][prev+1] = Math.max(take,not);
        return dp[idx][prev+1];
    } 
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        Arrays.sort(arr,(a,b)->a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        return recur(0,-1,arr,dp);
    }
}