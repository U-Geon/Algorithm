import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        // 1 -> 끝까지 가격이 떨어지지 않음 (후반부에 2 3 2 3 이니까)
        // 2 -> 끝까지 가격이 떨어지지 않음 (후반부에도 3 2 3 이니까)
        // 3 -> 1초간 가격이 떨어지지 않음 (2 3 이니까)
        // 2 -> 1초간 가격이 떨어지지 않음 (3 이니까)
        // 3 -> 0초간 가격이 떨어지지 않음
        int length = prices.length;
        int[] ans = new int[length];
        
        for(int i = 0; i < length; i++) {
            for(int j = i+1; j < length; j++) {
                ans[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        
        return ans;
    }
}