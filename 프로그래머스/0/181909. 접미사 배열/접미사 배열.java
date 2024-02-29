import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> arr = new ArrayList<>();
        
        for(int i=0; i<my_string.length(); i++) {
            arr.add(my_string.substring(i));
        }
        
        Collections.sort(arr);
        
        return arr.toArray(new String[0]);
    }
}