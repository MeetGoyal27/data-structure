class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            left = left + cardPoints[i];
            max = left;
        }
        int ri = cardPoints.length-1;
        for(int i = k-1;i>=0;i--){
            left = left - cardPoints[i];
            right = right + cardPoints[ri];
            ri--;
            max = Math.max(max,left + right);
        }
        return max;
    }
}