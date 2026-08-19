class Solution {
    public int[] findPrevious(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nums[i] = -1;
            }
            else{
                nums[i] = st.peek();
            }
            st.push(i);
        }
        return nums;
    }
    public int[] findNext(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nums = new int[n];
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nums[i] = n;
            }
            else{
                nums[i] = st.peek();
            }
            st.push(i);
        }
        return nums;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ns = findNext(heights);
        int[] ps = findPrevious(heights);
        int ans = 0;
        for(int i=0;i<n;i++){
            int h = heights[i];
            int w = ns[i] - ps[i] -1;
            ans = Math.max(ans,h*w);
        }
        return ans;
    }
}