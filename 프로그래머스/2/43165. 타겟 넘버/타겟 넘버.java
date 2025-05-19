import java.util.*;

class Node {
    int depth, sum;
    
    Node(int depth, int sum) {
        this.depth = depth;
        this.sum = sum;
    }
}

class Solution {

    public int solution(int[] numbers, int target) {
        
        int length = numbers.length;
        
        boolean[] visited = new boolean[length];
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(1, numbers[0]));
        queue.add(new Node(1, -numbers[0]));
        
        int cnt = 0;
        
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            int depth = tmp.depth;
            int sum = tmp.sum;
            
            if(depth == length) {
                if(sum == target) cnt++;
                continue;
            } else {
                queue.add(new Node(depth+1, sum + numbers[depth]));
                queue.add(new Node(depth+1, sum - numbers[depth]));   
            }
        }
        
        return cnt;
    }
}