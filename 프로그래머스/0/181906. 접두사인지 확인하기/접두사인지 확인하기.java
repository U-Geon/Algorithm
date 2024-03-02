class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        
        for(int i=0; i <= my_string.length(); i++) {
            String tmp = my_string.substring(0, i);
            if(tmp.equals(is_prefix)) answer = 1;
        }
        
        return answer;
    }
}