package B11726_2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        // dp 사용
        int[] tiles = new int[n + 1];
        tiles[1] = 1;
        tiles[2] = 2;

        for (int i = 3; i <= n; i++) {
            tiles[i] = (tiles[i - 1] + tiles[i - 2]) % 10007;
        }

        System.out.println(tiles[n]);
    }
}
