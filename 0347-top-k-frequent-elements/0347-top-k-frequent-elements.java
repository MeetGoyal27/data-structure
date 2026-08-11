class Solution {
    class Pair{
        int val;
        int freq;
        public Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(int key : map.keySet()){
            pq.offer(new Pair(key,map.get(key)));
        }
        int j=0;
        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans[j] = p.val;
            j++;
        }
        return ans;
    }
}