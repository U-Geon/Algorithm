import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int x = Integer.parseInt(br.readLine());

            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < x; j++) {
                BigInteger integer = new BigInteger(br.readLine());
                sum = sum.add(integer);
            }

            if (sum.compareTo(BigInteger.ZERO) < 0) {  // 음수
                System.out.println("-");
            } else if (sum.compareTo(BigInteger.ZERO) > 0) {    // 양수
                System.out.println("+");
            } else {
                System.out.println(0);
            }
        }
    }
}