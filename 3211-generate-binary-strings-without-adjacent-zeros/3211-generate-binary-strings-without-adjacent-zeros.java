class Solution {
    public void fun(StringBuilder sb, List<String> list,int n){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }
        sb.append('1');
        fun(sb,list,n);
        sb.deleteCharAt(sb.length()-1);
        if(sb.length() == 0 || sb.charAt(sb.length()-1) != '0'){
            sb.append('0');
            fun(sb,list,n);
            sb.deleteCharAt(sb.length()-1);

        }

    }
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        fun(new StringBuilder(),list,n);
        return list;

        
    }
}