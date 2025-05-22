import java.util.*;

class Solution {
    
    public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());        
        for(int i = 0; i < priorities.length; i++) {
            q.add(priorities[i]);
        }
        
        int result = 0;
        // 3 2 2 1
        // 9 1 1 1 1 1
        while(!q.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == q.peek()) {
                    q.poll();
                    result++;
                    if(i == location) {
                        return result;
                    }
                }
            }
        }
        
        return 0;
    }
}