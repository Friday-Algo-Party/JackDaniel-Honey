package B9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
        // 1+1+1+1, 112, 121, 211, 22, 13, 31 (7)
        // 11111, 1112, 1121, 1211, 2111, 122, 212, 221, 131, 113, 311, 23, 32 (13)
        // 4+7+13 = 24
        // 7+13+24=44

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
