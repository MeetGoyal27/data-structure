class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] freq = new int[101];
        for(int x : nums){
            freq[x]++;
        }
        Arrays.sort(nums);
        int minValue = nums[0];
        int minFreq = freq[nums[0]];
        for(int x : nums){
            if(x > minValue && freq[x] != minFreq){
                return new int[]{minValue,x};
            }
        }
        return new int[]{-1,-1};

    }
}