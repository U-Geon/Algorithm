import java.util.*;

class Node implements Comparable<Node>{
    int start, end, weight;
    
    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class Solution {
    
    int[] parents;
    
    public void union(int u, int v) {
        int nu = find(u);
        int nv = find(v);
        
        System.out.println("nu = " + nu + ", nv = " + nv);
        
        if(nu > nv) parents[nu] = nv;
        else parents[nv] = nu;
    }
    
    public int find(int num) {
        if(parents[num] == num) return parents[num];
        
        parents[num] = find(parents[num]);
        return parents[num];
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        PriorityQueue<Node> queue = new PriorityQueue<>();
        
        for(int[] cost : costs) {
            queue.add(new Node(cost[0], cost[1], cost[2]));
        }
        
        parents = new int[n];
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }
        
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            
            if(find(tmp.end) == find(tmp.start)) continue;
            
            union(tmp.start, tmp.end);
            answer += tmp.weight;
        }
        
        System.out.println(Arrays.toString(parents));
        
        return answer;
    }
}