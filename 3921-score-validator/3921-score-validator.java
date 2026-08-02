class Solution {
    public int[] scoreValidator(String[] events) {
        int[] ans = new int[2];
        int totalScore = 0;
        int counter = 0;
        for(int i=0;i<events.length;i++){
            if(events[i].equals("W")){
                counter++;
                if(counter == 10){
                    break;
                }
            }
            else if(events[i].equals("WD") || events[i].equals("NB")){
                totalScore++;
            }
            else{
                totalScore += Integer.parseInt(events[i]);
            }
        }
        ans[0] = totalScore;
        ans[1] = counter;
        return ans;
    }
}