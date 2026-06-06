class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        String one = strs[0];
        String two = strs[strs.length-1];
        char[] first = one.toCharArray();
        char[] second = two.toCharArray();
        for(int i=0;i<first.length;i++){
            if(first[i] == second[i]){
                sb.append(first[i]);
            }
            else{
                break;
            }
        }
        return sb.toString();

    }
}