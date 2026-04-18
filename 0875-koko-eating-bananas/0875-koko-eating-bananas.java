class Solution {
    public boolean isAns(int[] piles,int speed,int h){
        int ans = 0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]%speed == 0){
                ans += piles[i]/speed;
            }
            else{
                ans += (piles[i]/speed)+1;
            }
            if(ans>h){
                return false;
            }
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int num : piles){
            end = Math.max(num,end);
        }
        int ans = -1;
        while(start<=end){
            int mid = (start+end)/2;
            if(isAns(piles,mid,h)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;
        
    }
}