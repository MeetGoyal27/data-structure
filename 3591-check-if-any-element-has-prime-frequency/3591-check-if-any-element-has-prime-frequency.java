class Solution {
    public boolean isPrime(int n){
        if(n==0 || n==1){
            return false;
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(n%i==0){
                count++;
            }
        }
        return count == 0;
    }
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int key : map.keySet()){
            if(isPrime(map.get(key))){
                return true;
            }
        }
        return false;
    }
}