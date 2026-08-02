class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A' || ch=='e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch=='u' || ch=='U'){
            return true;
        }
        return false;
    }
    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        for(char x : s.toCharArray()){
            if(isVowel(x)){
                list.add(x);
            }
        }
        Collections.sort(list);
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVowel(ch)){
                sb.append(list.get(j));
                j++;
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}