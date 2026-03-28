class Solution {
    public double myPow(double x, int n) {
        double answer = 1.0;

        long nn = n;

        if(nn < 0) 
            nn = -1 * nn;

        while(nn > 0) {
            if(nn % 2 == 1) {
                answer *= x;
                nn -= 1;
            }
            else {
                x *= x;
                nn /= 2;
            }
        }

        if(n < 0) {
            answer = (double)(1.0) / (double)(answer);
        }

        return answer;
        
        

    }
}