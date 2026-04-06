class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int y = x;
        int ans = 0;
        while(y>0){
            int rem = y % 10;
            ans = ans + rem;
            y = y/10;
        }
        if(x % ans == 0){
            return ans;
        }
        return -1;
        
    }
}