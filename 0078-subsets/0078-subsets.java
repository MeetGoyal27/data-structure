class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums,0,list,ans);
        return ans;
    }
    public void helper(int[] nums,int idx,List<Integer> list,List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[idx]);
        helper(nums,idx+1,list,ans);
        list.remove(list.size()-1);
        helper(nums,idx+1,list,ans);

    }
}