class Solution {
    public void fun(int idx,int sum,List<Integer> li,List<List<Integer>> list,int[] arr,int k){
        if(sum == k){
            list.add(new ArrayList<>(li));
            return;
        }
        if(sum>k){
            return;
        }
        if(idx == arr.length){
            return;
        }
        li.add(arr[idx]);
        fun(idx+1,sum+arr[idx],li,list,arr,k);
        li.remove(li.size()-1);
        int i = idx+1;
        while(i < arr.length && arr[i] == arr[i-1]){
            i++;
        }
        fun(i,sum,li,list,arr,k);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> li = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        fun(0,0,li,list,candidates,target);
        return list;
        
    }
}