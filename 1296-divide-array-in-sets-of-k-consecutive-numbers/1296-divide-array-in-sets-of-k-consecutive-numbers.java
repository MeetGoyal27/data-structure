class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0){
            return false;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        while(map.size()>0){
            int key = map.firstKey();
            for(int i=0;i<k;i++){
                int next = key+i;
                if(!map.containsKey(next)){
                    return false;
                }
                map.put(next,map.get(next)-1);
                if(map.get(next) == 0){
                    map.remove(next);
                }
            }
        }
        return true;
    }
}