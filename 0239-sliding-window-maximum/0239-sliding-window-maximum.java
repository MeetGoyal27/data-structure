import java.util.*;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        //Best case:-compute left max and right max for every window 
        int n=nums.length;
        int[] left_max= new int[n];
        int[] right_max=new int[n];
        int[] ans= new int[n-k+1];

        for(int i=0;i<n;i++){
            if(i%k==0){
                left_max[i]=nums[i];
            }
            else{
                left_max[i]=Math.max(left_max[i-1],nums[i]);
            }
        }

        for(int i=n-1;i>=0;i--){
            if(i%k==0 || i==n-1){
                right_max[i]=nums[i];
            }
            else{
                right_max[i]=Math.max(right_max[i+1],nums[i]);
            }
        }

        for(int i=0;i<ans.length;i++){
            ans[i]=Math.max(right_max[i],left_max[i+k-1]);
        }

        return ans;
    }
}