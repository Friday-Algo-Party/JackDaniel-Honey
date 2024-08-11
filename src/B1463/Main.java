package B1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        dp = new Integer[x + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(x));
    }

    static int recur(int x) {
        if(dp[x] == null) {
            if (x % 6 == 0) {
                dp[x] = Math.min(recur(x - 1), Math.min(recur(x/3), recur(x/2))) + 1;
            }

            else if (x % 3 == 0) {
                dp[x] = Math.min(recur(x / 3), recur(x - 1)) + 1;
            }

            else if ( x % 2 == 0) {
                dp[x] = Math.min(recur(x / 2), recur(x - 1)) + 1;
            }

            else {
                dp[x] = recur(x - 1) + 1;
            }
        }
        return dp[x];
    }
}
