import java.util.*;

class Solution {
    
    public int bfs(int n, List<List<Integer>> graph) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[0] = 0;
        dist[1] = 0;
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            
            for(int neighbor : graph.get(tmp)) {
                if(dist[neighbor] == Integer.MAX_VALUE) {
                    dist[neighbor] = dist[tmp] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        int maxValue = Arrays.stream(dist).max().getAsInt();
        
        return (int) Arrays.stream(dist)
            .filter(x -> x == maxValue)
            .count();
    }
    
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i < n+1; i++) {
            graph.add(new ArrayList());
        }
        
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        return bfs(n, graph);
    }
}