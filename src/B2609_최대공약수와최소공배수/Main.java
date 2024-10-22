package B2609_최대공약수와최소공배수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int gcd = 0;
    static int lcm = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        GCD(x, y);
        LCM(x, y);
        System.out.println(gcd);
        System.out.println(lcm);
    }
    public static void GCD(int x, int y) {
        for (int i = Math.min(x, y); i >= 1; i--) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
                return;
            }
        }
    }

    public static void LCM(int x, int y) {
        for (int i = Math.max(x, y); i <= x * y; i++) {
            if (i % x == 0 && i % y == 0) {
                lcm = i;
                return;
            }
        }
    }
}
