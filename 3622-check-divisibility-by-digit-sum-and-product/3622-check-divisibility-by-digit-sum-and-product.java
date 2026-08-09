class Solution {
    public int mul(int n){
        int m = 1;
        while(n>0){
            int rem = n%10;
            m *= rem;
            n = n/10;
        }
        return m;
    }
    public int sum(int n){
        int s = 0;
        while(n>0){
            int rem = n%10;
            s+=rem;
            n=n/10;
        }
        return s;
    }
    public boolean checkDivisibility(int n) {
        int s = sum(n);
        int m = mul(n);
        int add = s+m;
        if(n%add==0){
            return true;
        }
        return false;
    }
}