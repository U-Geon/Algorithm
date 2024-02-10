class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int tmp = a;
        for(boolean i : included) {
            if(i) answer += tmp;
            tmp += d;
        }
        return answer;
    }
}