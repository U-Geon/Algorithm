import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        ArrayList<Integer> stk = new ArrayList<>();
        
        int i=0;
        while(i < arr.length) {
            if(stk.isEmpty()) stk.add(arr[i++]);
            else {
                int lastValue = stk.get(stk.size() - 1);
                if(lastValue < arr[i]) {
                    stk.add(arr[i++]);
                } else {
                    stk.remove(stk.size() - 1);
                }
            }
        }
        
        int[] answer = stk.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}