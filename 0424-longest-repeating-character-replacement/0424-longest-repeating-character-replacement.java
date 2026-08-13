class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int left=0;
        int right=0;
        int maxFreq=0;
        int ans=0;
        while(right<s.length()){
            char ch = s.charAt(right);
            arr[ch-'A']++;
            maxFreq = Math.max(maxFreq,arr[ch-'A']);
            while(right-left+1-maxFreq > k){
                arr[s.charAt(left)-'A']--;
                left++;
            }
            ans=Math.max(right-left+1,ans);
            right++;
        }
        return ans;
    }
}