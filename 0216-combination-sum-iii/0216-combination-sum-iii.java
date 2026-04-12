class Solution {
    public void fun(int idx,int sum,int k,int n,List<Integer> li, List<List<Integer>> list){
        if(sum == n && k == 0){
            list.add(new ArrayList<>(li));
            return;
        }
        if(sum>n){
            return;
        }


        for(int i=idx;i<=9;i++){
            li.add(i);
            fun(i+1,sum+i,k-1,n,li,list);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        fun(1,0,k,n,li,list);
        return list;
    }
}