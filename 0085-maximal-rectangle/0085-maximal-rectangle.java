class Solution {
    public int maximalRectangle(char[][] matrix) {
        int largest = 0;
        int[] ans = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val = matrix[i][j] - '0';
                if(val == 0){
                    ans[j] = 0;
                }
                else{
                    ans[j] = ans[j] + val;
                }
            }
            int max = largestRectangleArea(ans);
            if(max > largest){
                largest = max;
            }

        }
        return largest;
        
    }
    public int largestRectangleArea(int[] heights) {
        final int n = heights.length;

        int[] leftSmall = firstSmallOnLeft(heights, n);
        int[] rightSmall = firstSmallOnRight(heights, n);        

        int ans = 0;
        for(int i=0; i<n; i++) {
            int leftIndex = leftSmall[i];
            int rightIndex = rightSmall[i];

            int width = rightIndex - leftIndex - 1;
            int height = heights[i];

            int area = width * height;
            ans = Math.max(ans, area);
        }

        return ans;        
    }
    public int[] firstSmallOnRight(int[] heights, int n) {
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        

        for(int i=n-1; i>=0; i--) {
            while(st.size()>0 && heights[st.peek()] >= heights[i] ){
                st.pop();
            }
            if(st.size() == 0){
              arr[i] = n;
            }
            else{

            arr[i] = st.peek();
            }
            st.push(i);
        }

        return arr;

    }
    public int[] firstSmallOnLeft(int[] heights, int n) {
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        

        for(int i=0; i<n; i++){
            while(st.size() > 0 && heights[st.peek()] >= heights[i] ){
                st.pop();
            }
            if(st.size() == 0){
                arr[i] = -1;
            }
            else{
         arr[i] = st.peek();
            }
            
            st.push(i);
        }

        return arr;
    }
}
