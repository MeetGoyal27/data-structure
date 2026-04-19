class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        int idx = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(idx<k){
            sum += nums[idx];
            if(map.containsKey(nums[idx])){
                map.put(nums[idx],map.get(nums[idx])+1);
            }
            else{
                map.put(nums[idx],1);
            }
            idx++;
        }
        if(map.size() == k){
            ans = Math.max(ans,sum);
        }
        for(int i=1;i<n-k+1;i++){
            sum -= nums[i-1];
            if(map.get(nums[i-1]) == 1){
                map.remove(nums[i-1]);
            }
            else{
                map.put(nums[i-1],map.get(nums[i-1])-1);
            }
            sum += nums[i+k-1];
            if(map.containsKey(nums[i+k-1])){
                map.put(nums[i+k-1],map.get(nums[i+k-1])+1);
            }
            else{
                map.put(nums[i+k-1],1);
            }
            if(map.size() == k){
                ans = Math.max(ans,sum);
            }
        }
        return ans;

        
    }
}