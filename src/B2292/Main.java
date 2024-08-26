package B2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int beeCnt = 1; // 현재 층
        int currentMax = 1; // 현재 층의 최대 방 번호

        while (N > currentMax) {
            currentMax += 6 * beeCnt;
            beeCnt++;
        }

        System.out.println(beeCnt);
    }
}
