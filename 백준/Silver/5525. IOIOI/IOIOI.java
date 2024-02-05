import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int ans = 0;

    // KMP 알고리즘
    static void solution(String text, String pattern) {
        int[] fail = fail(pattern);
        int m = pattern.length();
        int j = 0;

        for (int i = 0; i < text.length(); i++) {
            while(j > 0 && text.charAt(i) != pattern.charAt(j)) j = fail[j-1];
            if(text.charAt(i) == pattern.charAt(j)) {
                if(j == m-1) {
                    ans++;
                    j = fail[j];
                } else j++;
            }
        }
    }

    static int[] fail(String text) {

        int[] fail = new int[text.length()];
        int j = 0;

        for (int i = 1; i < text.length(); i++) {
            while(j > 0 && text.charAt(i) != text.charAt(j)) j = fail[j-1];
            if(text.charAt(i) == text.charAt(j)) fail[i] = ++j;
        }

        return fail;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().strip());
        int m = Integer.parseInt(br.readLine().strip());
        String str = br.readLine().strip();
        StringBuilder pattern = new StringBuilder("I");
        for (int i = 0; i < n; i++) {
            pattern.append("OI");
        }

        solution(str, pattern.toString());

        System.out.println(ans);
    }
}