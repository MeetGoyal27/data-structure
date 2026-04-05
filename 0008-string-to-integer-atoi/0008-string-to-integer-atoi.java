class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        long ans = 0;
        int idx = 0;
        int sign = 1;
        if(s.charAt(0) == '+'){
            idx++;
        }
        else if(s.charAt(0) == '-'){
            idx++;
            sign = -1;
        }
        while(idx < s.length() && Character.isDigit(s.charAt(idx))){
            int digit = s.charAt(idx) - '0';
            ans = ans*10 + digit;
            if(sign == 1 && ans > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && -ans < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            idx++;
        }
        return (int)(sign*ans);
    }
}