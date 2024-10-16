package B1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] loc = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;

        while(!q.isEmpty()) {
            int current = q.poll();

            if (current == X) {
                System.out.println(loc[current]);
                return;
            }

            if (current - 1 >= 0 && !visited[current - 1]) {
                q.offer(current - 1);
                visited[current - 1] = true;
                loc[current - 1] = loc[current] + 1;
            }

            if (current + 1 < loc.length && !visited[current + 1]) {
                q.offer(current + 1);
                visited[current + 1] = true;
                loc[current + 1] = loc[current] + 1;
            }

            if (current * 2 < loc.length && !visited[current * 2]) {
                q.offer(current * 2);
                visited[current * 2] = true;
                loc[current * 2] = loc[current] + 1;
            }
        }

    }
}
