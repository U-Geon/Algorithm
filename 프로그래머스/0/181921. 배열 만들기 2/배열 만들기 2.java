import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=l; i<=r; i++) {
            if(i % 5 == 0) {
                String s = String.valueOf(i);
                boolean flag = true;
                
                for(int j=0; j < s.length(); j++) {
                    char chr = s.charAt(j);
                    if(chr != '5' && chr != '0') {
                        flag = false;
                        break;
                    }
                }
                if(flag) arr.add(i);
            }
        }
        
        int[] answer = arr.stream().mapToInt(Integer::intValue).toArray();
        if(answer.length == 0) return new int[]{-1};
        else return answer;
    }
}