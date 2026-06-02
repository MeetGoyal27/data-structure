class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '('){
                s1.push(i);
            }
            else if(arr[i] == '*'){
                s2.push(i);
            }
            else{
                if(!s1.isEmpty()){
                    s1.pop();
                }
                else if(!s2.isEmpty()){
                    s2.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(s1.size()>0 && s2.size()>0 && s1.peek() < s2.peek()){
            s1.pop();
            s2.pop();
        }
        return s1.isEmpty();
    }
}