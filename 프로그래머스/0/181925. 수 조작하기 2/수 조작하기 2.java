class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int tmp = numLog[0];
        
        for(int i=1; i<numLog.length; i++) {
            int process = numLog[i] - tmp;
            if(process == 1) answer += "w";
            else if(process == -1) answer += "s";
            else if(process == 10) answer += "d";
            else answer += "a";
                
            tmp = numLog[i];
        }
        
        return answer;
    }
}