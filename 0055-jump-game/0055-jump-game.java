class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int i=0;
        while(i<nums.length){
            if(i>max){
                return false;
            }
            max = Math.max(max,i+nums[i]);
            i++;
        }
        return true;
        
    }
}