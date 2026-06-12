class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                ans = Math.max(ans,j-i+1);
                j++;
            }
            else{
                while(set.contains(ch)){
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(ch);
                j++;
            }
        }
        return ans;
    }
}