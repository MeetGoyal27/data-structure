class Solution {

    public void solution(int idx,int[] candidates,int target,List<List<Integer>> res,List<Integer> des){
        if(idx == candidates.length){
            if(target == 0){
                res.add(new ArrayList<>(des));
            }
            return;
        }
         if(candidates[idx] <= target){
        des.add(candidates[idx]);
        solution(idx,candidates,target-candidates[idx],res,des);
        des.remove(des.size()-1);
         }
        solution(idx+1,candidates,target,res,des);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> des = new ArrayList<>();
        solution(0,candidates,target,res,des);
        return res;
        
    }
}