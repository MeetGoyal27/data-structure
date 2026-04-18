class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end<fruits.length){
            if(map.containsKey(fruits[end])){
                map.put(fruits[end],map.get(fruits[end])+1);
            }
            else{
                map.put(fruits[end],1);
            }
            while(map.size()>2){
                if(map.get(fruits[start]) == 1){
                    map.remove(fruits[start]);
                    start++;
                }
                else{
                    map.put(fruits[start],map.get(fruits[start])-1);
                    start++;
                    
                }
            }
            ans = Math.max(ans,end-start+1);
            end++;
        }
        return ans;

    }
}