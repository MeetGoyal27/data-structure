class Solution {
    public int countbits(int n){
        int count = 0;
        while(n>1){
            if(n%2 == 1){
                count++;
            }
            n = n/2;
        }
        return count+1;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=1;i<ans.length;i++){
            ans[i] = countbits(i);
        }
        return ans;
    }
}