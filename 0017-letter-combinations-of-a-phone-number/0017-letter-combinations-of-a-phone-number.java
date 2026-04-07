class Solution {
    public void fun(int idx,String digits,List<String> list, HashMap<Character,String> map,StringBuilder sb){
        if(idx == digits.length()){
            list.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(idx));
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            fun(idx+1,digits,list,map,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        fun(0,digits,list,map,new StringBuilder());

        return list;

        
    }
}