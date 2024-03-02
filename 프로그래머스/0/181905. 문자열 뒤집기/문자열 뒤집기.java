class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string.substring(s, e+1));
        
        String tmp1 = my_string.substring(0, s);
        String tmp2 = sb.reverse().toString();
        String tmp3 = my_string.substring(e+1);
        return tmp1 + tmp2 + tmp3;
    }
}