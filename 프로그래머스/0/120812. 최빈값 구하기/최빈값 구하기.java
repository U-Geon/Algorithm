import java.util.*;

class Solution {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        // 최빈값 및 최빈값의 빈도수
        int mode = -1;
        int maxFrequency = 0;
        
        // 빈도수가 가장 높은 값을 찾음
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                mode = entry.getKey();
                maxFrequency = frequency;
            } else if (frequency == maxFrequency) {
                // 최빈값이 여러 개인 경우
                mode = -1;
            }
        }
        return mode;
    }
}