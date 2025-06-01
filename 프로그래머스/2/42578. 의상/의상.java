import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String[] arr : clothes) {
            String name = arr[0];
            String category = arr[1];
            
            List<String> tmp = map.getOrDefault(category, new ArrayList<>());
            tmp.add(name);
            
            map.put(category, tmp);
        }
        
        int result = 1;
        int length = map.keySet().size();
        
        for(String s : map.keySet()) {
            
            result *= map.get(s).size() + 1;
        }
        
        return result - 1;
    }
}