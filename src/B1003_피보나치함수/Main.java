package B1003_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] table = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        table[0][0] = 1;
        table[0][1] = 0;
        table[1][0] = 0;
        table[1][1] = 1;

        // 피보나치 수열 값 계산
        for (int i = 2; i <= 40; i++) {
            table[i][0] = table[i-1][0] + table[i-2][0];
            table[i][1] = table[i-1][1] + table[i-2][1];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(table[N][0] + " " + table[N][1]);
        }
    }
}
