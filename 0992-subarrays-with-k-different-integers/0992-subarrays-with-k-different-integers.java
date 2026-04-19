class Solution {
    public int fun(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end<arr.length){
            if(map.containsKey(arr[end])){
                map.put(arr[end],map.get(arr[end])+1);
            }
            else{
                map.put(arr[end],1);
            }
            while(map.size()>k){
                if(map.get(arr[start]) == 1){
                    map.remove(arr[start]);
                    start++;
                }
                else{
                    map.put(arr[start],map.get(arr[start])-1);
                    start++;
                }
            }
            ans += (end-start+1);
            end++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return fun(nums,k) - fun(nums,k-1);
    }
}