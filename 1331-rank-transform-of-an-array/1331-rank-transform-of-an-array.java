class Solution {
    public int[] arrayRankTransform(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int rank= 1;
        int[] nums = Arrays.copyOf(arr,arr.length);
        Arrays.sort(nums);
        for(int x : nums){
            if(!map.containsKey(x)){
                map.put(x,rank);
                rank++;
            }
        }
        for(int i=0;i<nums.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;

    }
}