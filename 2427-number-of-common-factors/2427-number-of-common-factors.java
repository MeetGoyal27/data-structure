class Solution {
    public int commonFactors(int a, int b){
        List<Integer> list = new ArrayList<>();
        int max = Math.max(a,b);
        for(int i=1;i<=max;i++){
            if(a%i == 0 && b%i==0){
                list.add(i);
            }
        }
        return list.size();
    }

}