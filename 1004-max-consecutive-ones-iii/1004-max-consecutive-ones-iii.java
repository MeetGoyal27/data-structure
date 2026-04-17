class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int start = 0;
        int end = 0;
        int zeroes = 0;
        while(end<nums.length){
            if(nums[end] == 1){
                ans = Math.max(ans,end-start+1);
                end++;
            }
            else{
                zeroes++;
                while(zeroes>k){
                    if(nums[start] == 0){
                        start++;
                        zeroes--;
                    }
                    else{
                        start++;
                    }
                }
                ans = Math.max(ans,end-start+1);
                end++;
            }
        }
        return ans;
        
    }
}