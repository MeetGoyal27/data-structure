class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0 || st.isEmpty()){
                st.push(asteroids[i]);
            }
            else{
                while(st.size()>0 && st.peek()>0 && Math.abs(asteroids[i])>st.peek()){
                    st.pop();
                }
                if(st.size()>0 && Math.abs(asteroids[i])==st.peek()){
                    st.pop();
                }
                else if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
            }
        }
        int[] ans = new int[st.size()];
        int j=0;
        while(st.size()>0){
            ans[j] = st.pop();
            j++;
        }
        int left = 0, right = ans.length - 1;
        while (left < right) {
            int temp = ans[left];
            ans[left] = ans[right];
            ans[right] = temp;
            left++;
            right--;
        }
       return ans;

    }
}
