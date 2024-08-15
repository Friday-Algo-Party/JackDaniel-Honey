package B1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int prime;
    public static int cnt;
    public static boolean isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        cnt = 0;

        for (int i = 0; i < N; i++) {
            prime = Integer.parseInt(st.nextToken());
            if (funcPrime(prime)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean funcPrime (int prime) {
        for (int i = prime - 1; i >= 2; i--) {
            if (prime % i == 0) {
                return false;
            }
        }
        if (prime == 1) {
            return false;
        }
        return true;
    }
}
