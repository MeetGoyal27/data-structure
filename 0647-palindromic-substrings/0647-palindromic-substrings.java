class Solution {
    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
                if(isPalindrome(sub)){
                    count++;
                }
            }
        }
        return count;
    }
}