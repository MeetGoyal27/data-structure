class Solution {
    public boolean isPossible(int[] arr,int speed,int limitHours){
        long currHours=0;
        for(int x : arr){
            if(x%speed==0){
                currHours += (x/speed);
            }
            else{
                currHours += (x/speed) + 1;
            }
        }
        return currHours <= limitHours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=0;
        for(int x : piles){
            end=Math.max(end,x);
        }
        int ans=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(isPossible(piles,mid,h)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
}