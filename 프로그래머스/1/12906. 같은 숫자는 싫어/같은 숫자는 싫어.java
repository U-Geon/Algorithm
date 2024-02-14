import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        
        for(int i=1; i < arr.length; i++) {
            if(answer.get(answer.size() - 1) != arr[i]) answer.add(arr[i]);
        }
        
        int[] result = new int[answer.size()];
        
        for(int i=0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}