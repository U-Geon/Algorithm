import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if(status.equals("enter")) {
                map.put(name, status);
            } else {
                map.remove(name);
            }
        }

        List<String> result = map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (String s : result) {
            System.out.println(s);
        }

        br.close();
    }
}