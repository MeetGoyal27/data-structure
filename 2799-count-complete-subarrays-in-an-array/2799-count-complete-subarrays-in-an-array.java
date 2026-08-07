class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        HashMap<Integer,Integer> m = new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            m.put(nums[j],m.getOrDefault(nums[j], 0) + 1);
            while(map.size() == m.size()){
                ans += nums.length-j;
                m.put(nums[i],m.get(nums[i])-1);
                if(m.get(nums[i]) == 0){
                    m.remove(nums[i]);
                }
                i++;

            }
            j++;
        }
        return ans;
    }
}