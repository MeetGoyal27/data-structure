class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        rec(0,nums,ds,ans);
        return ans;       
    }
    static void rec(int i,int[] nums,List<Integer> ds,List<List<Integer>> ans){
        if(i==nums.length){
            if(!ans.contains(ds))
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[i]);
        rec(i+1,nums,ds,ans);
        ds.remove(ds.size()-1);
        rec(i+1,nums,ds,ans);
        
    }
}