class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int j=0;
        int ans=0;
        HashSet<Character> set = new HashSet<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            ans=Math.max(ans,j-i+1);
            set.add(ch);
            j++;
        }
        return ans;
    }
}