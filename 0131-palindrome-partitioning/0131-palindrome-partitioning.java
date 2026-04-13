class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public void fun(String st,List<String> li,List<List<String>> list){
        if(st.length() == 0){
            list.add(new ArrayList<>(li));
            return;
        }
        for(int i=0;i<st.length();i++){
            String sub = st.substring(0,i+1);
            if(isPalindrome(sub)){
                li.add(sub);
                fun(st.substring(i+1),li,list);
                li.remove(li.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> li = new ArrayList<>();
        fun(s,li,list);
        return list;
        

        
    }
}