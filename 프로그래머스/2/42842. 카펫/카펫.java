class Solution {
    public int[] solution(int brown, int yellow) {
        
        int b =  brown / 2 + 2; // 7
        int c = brown + yellow; // 12
        
        // 근의 공식
        int width = b + (int) Math.sqrt(b * b - 4 * c);
        width /= 2;
        
        int height = b - (int) Math.sqrt(b * b - 4 * c);
        height /= 2;
        
        return new int[]{width, height};
    }
}