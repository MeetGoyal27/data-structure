class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.size() == 0){
                    return false;
                }
                char c = st.pop();
                if((ch==')' && c!='(') || (ch==']' && c!='[') || (ch=='}' && c!='{')){
                    return false;
                }
            }
        }
        return st.size() == 0;
    }
}