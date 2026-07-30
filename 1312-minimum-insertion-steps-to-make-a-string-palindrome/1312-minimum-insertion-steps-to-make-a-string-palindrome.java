class Solution {
    public int recur(int i,int j,String text1,String text2,int[][] dp){
        if(i==text1.length() || j==text2.length())
        {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + recur(i+1,j+1,text1,text2,dp);
            return dp[i][j];
        }
        else{
            int case1 = recur(i+1,j,text1,text2,dp);
            int case2 = recur(i,j+1,text1,text2,dp);
           dp[i][j] =  Math.max(case1,case2);
           return dp[i][j];
        }
    }
    public int minInsertions(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = s1.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int x = recur(0,0,s,s1,dp);
        return m-x;
    }
}