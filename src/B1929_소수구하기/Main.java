package B1929_소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        isPrime = new boolean[N+ 1];

        for (int i = 0; i <= N; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(isPrime[i]) {
                // 소수가 되는 수의 배수를 지운다
                for(int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for(int i = M; i <= N; i++) {
            if(isPrime[i]) {
                System.out.println(i);
            }
        }
    }
}
