import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int eTmp = 1, sTmp = 1, mTmp = 1, count = 1;

        while(eTmp != e || sTmp != s || mTmp != m) {
            eTmp++; sTmp++; mTmp++;
            count++;
            if(eTmp > 15) eTmp = 1;
            if(sTmp > 28) sTmp = 1;
            if(mTmp > 19) mTmp = 1;
        }

        System.out.println(count);
    }
}