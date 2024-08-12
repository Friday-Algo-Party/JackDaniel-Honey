package B2839;

import java.io.*;

public class Main {
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calc(N));
    }

    public static int calc(int N) {
        while (N > 0) {
            if (N % 5 == 0) {
                cnt += N/5;
//                System.out.println("5로 나눠지네, 결과는 " + N);
//                System.out.println("cnt는 " + cnt);
                break;
            }
            else if (N % 3 == 0) {
                N -= 3;
                cnt += 1;
//                System.out.println("3으로 나눠지네, 결과는 " + N);
//                System.out.println("cnt는 " + cnt);
                if (N == 0) {
                    break;
                }
            }
            else {
                N -= 3;
                cnt += 1;
//                System.out.println("걍 3 빼볼게, 결과는 " + N);
//                System.out.println("cnt는 " + cnt);
                if (N < 0) {
                    cnt = -1;
//                    System.out.println("0보다 작길래 바꿈 " + N);
                }
            }
        }
        return cnt;
    }

}