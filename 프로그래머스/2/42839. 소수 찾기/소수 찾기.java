import java.util.*;

class Solution {
    
    Set<Integer> primeSet = new HashSet<>();
    boolean[] visited;
    
    public void backTracking(String numbers, String current, int depth) {
        
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            primeSet.add(num);
        }
        
        if(depth == numbers.length()) return ;
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                backTracking(numbers, current + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }    
        }
        
    }
    
    public boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i=2; i < (int) Math.sqrt(n) + 1; i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
    
    public int solution(String numbers) {
        visited = new boolean[numbers.length()];
        backTracking(numbers, "", 0);
        
        int answer = 0;
        
        for(int i : primeSet) {
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
}