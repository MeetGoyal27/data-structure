class Solution {
    public void recur(int idx,List<List<Integer>> ans,int[] arr,List<Integer> list){
        if(idx == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[idx]);
        recur(idx+1,ans,arr,list);
        list.remove(list.size()-1);
        recur(idx+1,ans,arr,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recur(0,ans,nums,list);
        return ans;
    }
}