package B2869_달팽이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 낮에 올라감
        int B = Integer.parseInt(st.nextToken()); // 밤에 미끄러짐
        int V = Integer.parseInt(st.nextToken()); // 나무 막대의 높이

        // 마지막 날은 미끄러지지 않으므로 V - A 만큼 남은 거리를 A - B 로 나눈 후 1을 더해준다.
        int days = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            days++;  // 나머지가 있으면 하루 더 걸림
        }

        System.out.println(days);
    }
}
