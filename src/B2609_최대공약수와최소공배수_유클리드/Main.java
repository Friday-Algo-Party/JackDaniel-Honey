package B2609_최대공약수와최소공배수_유클리드;

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

        gcd = GCD(x, y);
        lcm = LCM(x, y, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법
    // 두 수 x와 y의 최대공약수는 y와 x%y의 최대공약수와 같다
    public static int GCD(int x, int y) {
        if(y == 0) {
            return x;
        }
        return GCD(y, x % y);
    }

    public static int LCM(int x, int y, int gcd) {
        return (x * y) / gcd;
    }
}
