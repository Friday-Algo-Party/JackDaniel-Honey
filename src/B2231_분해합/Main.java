package B2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int sum = i;
            String strNum = Integer.toString(i);
            for (int j = 0; j < strNum.length(); j++) {
                sum += strNum.charAt(j) - '0'; // 각 자릿수 더하기
            }
            if (sum == N) {
                System.out.println(i);
                return; // 생성자 찾으면 프로그램 종료
            }
        }
        // 반복문 종료된 뒤에도 생성자 찾지 못했다면 0 출력
        System.out.println(0);
    }
}
