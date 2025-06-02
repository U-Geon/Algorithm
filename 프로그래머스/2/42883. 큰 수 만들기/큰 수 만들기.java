import java.util.*;

class Solution {
    public String solution(String number, int k) {
        
        
        // 1 9 2 4
        // 하나씩 stack에 넣으면서, 그 다음 원소가 stack의 최고조보다 크다면 peek 제거
        // 1 넣기 -> 9 넣고 1빼기 -> 2 넣기 -> 4 넣고 2 빼기
        
        // 1 넣기 -> 1빼고 2넣기 -> 2빼고 3넣기 -> 1 넣기 -> 1빼고 2넣기 -> 3넣기 -> 4넣기
        
        // 4 넣기 -> 1넣기 -> 1빼기 / 4빼기 7 넣기 -> 7 넣기 -> 2 넣기 -> 2빼고 5넣기 -> 2 넣기
        // -> 2뺴고 8 넣기
        
        Stack<Character> stack = new Stack<>();
        int count = 0; // 숫자를 제거한 횟수
        
        for(char n : number.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() < n && count < k) {
                stack.pop();
                count++;
            }
            stack.push(n);
        }
        
        System.out.println("cnt : " + count);
        
        // 999 같은 경우, stack.push만 하게 됨. 따라서 버려야 하는 개수만큼 버리기
        while(count++ < k) {
            stack.pop();
        }
        
        int length = stack.size();
        char[] result = new char[length];
        
        for(int i = length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return new String(result);
    }
}