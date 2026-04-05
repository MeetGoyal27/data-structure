class Solution {
    public void fun(int open,int close,List<String> list,String s,int n){
        if(open == n && close == n){
            list.add(s);
            return;
        }
        if(open<n){
            fun(open+1,close,list,s+"(",n);
        }
        if(open>close){
            fun(open,close+1,list,s+")",n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        fun(0,0,list,"",n);
        return list;
    }
}