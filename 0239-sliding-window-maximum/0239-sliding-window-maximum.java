class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        while(index<k){
            while(dq.size()>0 && nums[index] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(index);
            index++;
        }
        ans[0] = nums[dq.peekFirst()];
        for(int i=1;i<nums.length-k+1;i++){
            if(dq.size()>0 && dq.peekFirst() <= i-1){
                dq.pollFirst();
            }
             while(dq.size()>0 && nums[i+k-1] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            dq.offerLast(i+k-1);
            ans[i] = nums[dq.peekFirst()];
        }
        return ans;
    }
}