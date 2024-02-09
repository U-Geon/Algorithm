class Solution {
    
    public int calc(int a, int b) {
        String answer = String.valueOf(a) + String.valueOf(b);
        return Integer.parseInt(answer);
    }
    
    public int solution(int a, int b) {
        int val1 = calc(a,b);
        int val2 = 2 * a * b;
        
        return val1 >= val2 ? val1 : val2;
    }
}