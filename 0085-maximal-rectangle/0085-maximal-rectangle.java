class Solution {
    public int[] findNext(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = n;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] findPrevious(int[] arr){
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(st.size()>0 && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] ps = findPrevious(heights);
        int[] ns = findNext(heights);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int h = heights[i];
            int w = ns[i] - ps[i] - 1;
            max = Math.max(max,h*w);

        }
        return max;
    }
    public int maximalRectangle(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[] arr = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int x = matrix[i][j] - '0';
                if(x == 0){
                    arr[j] = 0;
                }
                else{
                    arr[j] = arr[j] + x;
                }
            }
            int maxArea = largestRectangleArea(arr);
            max = Math.max(max,maxArea);
        }
        return max;
        
    }
}