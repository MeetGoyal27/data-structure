class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'A' || ch=='e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch=='u' || ch=='U'){
            return true;
        }
        return false;
    }
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j = arr.length-1;
        while(i<j){
            if(isVowel(arr[i]) && isVowel(arr[j])){
                char ch = arr[i];
                arr[i] = arr[j];
                arr[j] = ch;
                i++;
                j--;
            }
            else if(isVowel(arr[i])){
                j--;
            }
            else{
                i++;
            }
        }
        return new String(arr);
    }
}