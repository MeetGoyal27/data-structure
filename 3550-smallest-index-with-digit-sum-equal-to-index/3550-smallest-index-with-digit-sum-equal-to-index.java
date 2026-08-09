class Solution {
    public int func(int n){
        int sum = 0;
        while(n>0){
            int rem = n%10;
            sum += rem;
            n = n/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int sumOfDigits = func(nums[i]);
            if(sumOfDigits == i){
                return i;
            }
        }
        return -1;
    }
}