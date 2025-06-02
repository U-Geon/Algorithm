import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 거쳐간 숫자의 합이 가장 큰 경우
        // working backward
        // 맨 마지막 도착 시 맨 왼쪽 / 맨 오른쪽 / 가운데
        
        int length = triangle.length;
        
        int[][] dp = new int[length][];
        for(int i = 0; i < length; i++) {
            dp[i] = new int[i+1];
        }
        
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i < length; i++) {
            for(int j=0; j < triangle[i].length; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j == triangle[i].length - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        return Arrays.stream(dp[length-1]).max().getAsInt();
    }
}