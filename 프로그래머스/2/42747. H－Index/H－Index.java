import java.util.*;

class Solution {
    public int solution(int[] citations) {
        // 논문 N편 중 h번 이상 인용된 논문이 h편 이상이고, 나머지 논문이 H번 이하 인용
        Arrays.sort(citations);
        
        System.out.println(Arrays.toString(citations));
        
        int n = citations.length;
        
        // 0 1 3 5 6
        // 5 4 3 2 1
        for(int i = 0; i < n; i++) {
            int ans = n-i;
            
            if(citations[i] >= ans) {
                return ans;
            }
        }
        return 0;
    }
}