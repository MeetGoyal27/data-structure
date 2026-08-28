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
    public void recur(String s,List<String> ans,List<List<String>> list){
        if(s.length() == 0){
            list.add(new ArrayList<>(ans));
            return;
        }
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(isPalindrome(sub)){
                ans.add(sub);
                recur(s.substring(i+1),ans,list);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        recur(s,ans,list);
        return list;
    }
}