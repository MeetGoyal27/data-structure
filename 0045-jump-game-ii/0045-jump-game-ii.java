class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int i=0;
        int jumps = 0;
        int max = 0;
        int end = 0;
        while(i<nums.length-1){
            max = Math.max(max,i+nums[i]);
            if(i == end){
                jumps++;
                end = max;
            }
            i++;
        }
        return jumps;
        
    }
}