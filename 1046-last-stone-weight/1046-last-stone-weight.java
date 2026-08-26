class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones){
            pq.offer(x);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(Math.abs(first-second) > 0){
                pq.offer(first-second);
            }
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}