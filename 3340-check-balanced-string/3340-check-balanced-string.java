class Solution {
    public boolean isBalanced(String num) {
        int es = 0;
        int os = 0;
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            int no = ch-'0';
            if(i%2 == 0){
                es += no;
            }
            else{
                os += no;
            }
        }
        return es == os;
    }
}