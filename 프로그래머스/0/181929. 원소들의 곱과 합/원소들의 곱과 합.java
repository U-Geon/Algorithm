import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int mul = 1;
        for(int i : num_list) {
            mul *= i;
        }
        
        return mul < (int) Math.pow(sum, 2) ? 1 : 0;
    }
}