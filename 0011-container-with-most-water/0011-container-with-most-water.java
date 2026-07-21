class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        while(left<right){
            int l = right-left;
            int b = Math.min(height[left],height[right]);
            int area = l*b;
            max = Math.max(max,area);
            if(height[left]<height[right]){
                left++;
            }
            else if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
                right--;
            }

        }
        return max;
        
    }
}