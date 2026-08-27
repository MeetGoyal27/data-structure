class Solution {
    public void recur(int idx,int[] nums,List<Integer> ans,List<List<Integer>> list){
        if(idx == nums.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[idx]);
        recur(idx+1,nums,ans,list);
        ans.remove(ans.size()-1);
        recur(idx+1,nums,ans,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        recur(0,nums,ans,list);
        return list;
    }
}