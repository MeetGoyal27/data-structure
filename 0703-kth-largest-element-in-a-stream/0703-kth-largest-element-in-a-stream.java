class KthLargest {
    int k;
    ArrayList<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        list = new ArrayList<>();
        for(int x : nums){
            list.add(x);
        }
        
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */