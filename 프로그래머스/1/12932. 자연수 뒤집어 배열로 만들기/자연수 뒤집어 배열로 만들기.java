class Solution {
    public int[] solution(long n) {
        
        String num = String.valueOf(n);
        
        int[] answer = new int[num.length()];
        for(int i=0; i < num.length(); i++) {
            answer[i] = Integer.parseInt(String.valueOf(num.charAt(num.length()-i-1)));
        }
        
        return answer;
    }
}