import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[10][2];
        arr[0][0] = "black";
        arr[0][1] = "1";
        arr[1][0] = "brown";
        arr[1][1] = "10";
        arr[2][0] = "red";
        arr[2][1] = "100";
        arr[3][0] = "orange";
        arr[3][1] = "1000";
        arr[4][0] = "yellow";
        arr[4][1] = "10000";
        arr[5][0] = "green";
        arr[5][1] = "100000";
        arr[6][0] = "blue";
        arr[6][1] = "1000000";
        arr[7][0] = "violet";
        arr[7][1] = "10000000";
        arr[8][0] = "grey";
        arr[8][1] = "100000000";
        arr[9][0] = "white";
        arr[9][1] = "1000000000";

        String color1 = br.readLine();
        String color2 = br.readLine();
        String color3 = br.readLine();

        long answer = 1;
        int ten = 0;
        for (int i = 0; i < 10; i++) {
            if(arr[i][0].equals(color1)) {
                ten += 10 * i;
            }
            if(arr[i][0].equals(color2)) {
                ten += i;
            }
            if(arr[i][0].equals(color3)) {
                answer = answer * Long.parseLong(arr[i][1]);
            }
        }

        System.out.println(answer * ten);
    }
}
