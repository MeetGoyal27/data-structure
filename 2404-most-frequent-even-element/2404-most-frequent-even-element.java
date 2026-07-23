class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            if(x%2==0){
                if(map.containsKey(x)){
                    map.put(x,map.get(x)+1);
                }
                else{
                    map.put(x,1);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a).equals(map.get(b)) ? a-b : map.get(b)-map.get(a));
        for(int key : map.keySet()){
            pq.offer(key);
        }
        return pq.peek() == null ? -1 : pq.poll();
    }
}