class Solution {
    public void recur(int open,int close,int n,String str,List<String> list){
        if(open == n && close == n){
            list.add(str);
            return;
        }
        if(open<n){
            recur(open+1,close,n,str+"(",list);
        }
        if(open>close){
            recur(open,close+1,n,str+")",list);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recur(0,0,n,"",list);
        return list;
    }
}