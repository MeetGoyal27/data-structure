class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end<s.length()){
            char ch = s.charAt(end);
            if(!set.contains(ch)){
                set.add(ch);
                ans = Math.max(ans,end-start+1);
                end++;
            }
            else{
                while(set.contains(ch)){
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(ch);
                end++;
            }
        }
        return ans;
    }
}