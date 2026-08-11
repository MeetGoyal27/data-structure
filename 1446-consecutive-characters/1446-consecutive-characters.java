class Solution {
    public int maxPower(String s) {
        int max=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.size()==1){
                    max=Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}