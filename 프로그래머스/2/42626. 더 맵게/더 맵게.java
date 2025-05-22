import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        int mix = -1;
        int ans = 0;
        while (pq.peek() < K) {
            if (pq.size() < 2) {
                return -1;
            }
            int first = pq.poll();
            int second = pq.poll();
            mix = first + second * 2;
            pq.add(mix);
            ans++;
        }
        
        return ans;
    }
}