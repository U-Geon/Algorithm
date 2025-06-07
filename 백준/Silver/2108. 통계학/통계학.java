import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int sum = Arrays.stream(arr).sum();
        int length = arr.length;
        System.out.println(Math.round((double) sum / length));

        Arrays.sort(arr);
        System.out.println(arr[length / 2]);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxCount = Collections.max(map.values());

        // 최빈값 후보들 수집
        List<Integer> modeCandidates = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                modeCandidates.add(entry.getKey());
            }
        }

        // 최빈값 후보가 하나면 그대로 리턴
        if (modeCandidates.size() == 1) {
            System.out.println(modeCandidates.get(0));
        } else {
            Collections.sort(modeCandidates);
            System.out.println(modeCandidates.get(1));
        }

        System.out.println(arr[n-1] - arr[0]);
    }
}
