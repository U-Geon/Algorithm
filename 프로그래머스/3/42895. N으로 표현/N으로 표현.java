import java.util.*;

class Solution {
    
    // working backward
    // 5 하나만 사용해서 나올 수 있는 경우
    // 5
    // 5를 두 개 사용해서 나올 수 있는 경우 (중복되면 x)
    // 5+5 & 5/5 & 5*5 & 5-5 x & 55 [10, 1, 25, 55]
    // 5를 3개 사용해서 나올 수 있는 경우 
    // ...
    // 이전 결과에 대해 사칙연산 적용.
    
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++) {
            // 5 55 555, ... 넣기
            int n = Integer.parseInt(String.valueOf(N).repeat(i));
            dp.get(i).add(n);
            
            // 모든 경우에 대한 사칙연산 결과 대입
            for(int j = 1; j < i; j++) { // i = 3 j = 1, j = 2
                // 이전 DP 까지의 모든 연산 결과를 저장
                for(int a : dp.get(j)) {
                    for(int b : dp.get(i-j)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(b - a);
                        dp.get(i).add(a * b);
                        if(a != 0) dp.get(i).add(b/a);
                        if(b != 0) dp.get(i).add(a/b);
                    }
                }
            }
            
            if(dp.get(i).contains(number)) {
                return i;
            }

        }
        return -1;
    }
}