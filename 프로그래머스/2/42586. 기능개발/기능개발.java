import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        ArrayList<Integer> stack = new ArrayList<>();
        
        int works;
        for(int i=0; i<speeds.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) 
                works = (100 - progresses[i]) / speeds[i];
            else works = (100 - progresses[i]) / speeds[i] + 1;
            stack.add(works);
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 1;
        int before = stack.get(0);
        
        for(int i=1; i < stack.size(); i++) {
            // 5 10 1 1 20 1 // 5 10 10 10 20 20
            if(before < stack.get(i)) {
                arr.add(count);
                count = 0;
            }
            count++;
            before = Math.max(stack.get(i), before);
        }
        arr.add(count);
        
        Integer[] array = arr.toArray(new Integer[0]);

        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = array[i];
        }

        return intArray;
    }
}