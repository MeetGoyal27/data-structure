class Solution {
    public char shift(char a,char b){
        int num = b-'0';
        return (char)(a+num);
    }
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else{
                char sh = shift(s.charAt(i-1),s.charAt(i));
                sb.append(sh);
            }
        }   
        return sb.toString();
    }
}