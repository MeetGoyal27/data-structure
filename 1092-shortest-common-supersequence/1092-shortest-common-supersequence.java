class Solution {
    public int recur(int i,int j,String s,String t,int[][] dp){
        if(i == s.length() || j == t.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = 1+recur(i+1,j+1,s,t,dp);
            return dp[i][j];
        }
        else{
            dp[i][j] = Math.max(recur(i+1,j,s,t,dp),recur(i,j+1,s,t,dp));
            return dp[i][j];
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int len = recur(0,0,str1,str2,dp);
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while(i<m && j<n){
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if(dp[i+1][j] >= dp[i][j+1]){
                sb.append(str1.charAt(i));
                i++;
            }
            else{
                sb.append(str2.charAt(j));
                j++;
            }
        }
        while(i<m){
            sb.append(str1.charAt(i));
            i++;
        }
        while(j<n){
            sb.append(str2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}