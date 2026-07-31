class Solution {
    public boolean recur(int i,int j,String s,String p,Boolean[][] dp){
        if(i == s.length() && j == p.length()){
            dp[i][j] = true;
            return true;
        }
        if(i == s.length()){
            while(j<p.length()){
                if(p.charAt(j) != '*'){
                    return false;
                }
                j++;
            }
            return true;
        }
        if(j == p.length()){
            return false;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j]= recur(i+1,j+1,s,p,dp);
            return dp[i][j];
        }
        if(p.charAt(j) == '*'){
            dp[i][j] = recur(i+1,j,s,p,dp) || recur(i,j+1,s,p,dp);
            return dp[i][j];
        }
        dp[i][j] = false;
        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return recur(0,0,s,p,dp);
    }
}