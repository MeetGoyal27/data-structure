class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for(int x : gas){
            totalGas += x;
        }
        for(int x : cost){
            totalCost += x;
        }
        if(totalGas < totalCost){
            return -1;
        }
        int start = 0;
        int currGas = 0;
        for(int i=0;i<gas.length;i++){
            currGas += (gas[i]-cost[i]);
            if(currGas<0){
                start = i+1;
                currGas = 0;
            }
        }
        return start;
    }
}