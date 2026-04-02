class Solution {
    public int[] previousSmaller(int[] arr){
        int n = arr.length;
         int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else if(arr[i] > arr[st.peek()]){
                ans[i] = st.peek();
            }
            else{
                while(st.size()>0 && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = -1;
                }
                else{
                    ans[i] = st.peek();
                }
            }
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmaller(int[] arr){
        int n = arr.length;
         int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i] = n;
            }
            else if(arr[i] > arr[st.peek()]){
                ans[i] = st.peek();
            }
            else{
                while(st.size()>0 && arr[i]<=arr[st.peek()]){
                    st.pop();
                }
                if(st.isEmpty()){
                    ans[i] = n;
                }
                else{
                    ans[i] = st.peek();
                }
            }
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] ps = previousSmaller(heights);
        int[] ns = nextSmaller(heights);
        int max = 0;
        for(int i=0;i<heights.length;i++){
            int h = heights[i];
            int w = ns[i]-ps[i]-1;
            max = Math.max(max,(h*w));
        }
        return max;
    }
}