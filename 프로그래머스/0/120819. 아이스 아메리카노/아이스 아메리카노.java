import java.util.*;

class Solution {
    public int[] solution(int money) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        int coffee = money / 5500;
        int changes = money - coffee * 5500;
        
        arr.add(coffee);
        arr.add(changes);
        
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}