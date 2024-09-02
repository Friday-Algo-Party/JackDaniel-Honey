package B2606_Dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] checked;
    static int[][] arr;
    static int cnt = 0;
    static int comCnt, conn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comCnt = Integer.parseInt(br.readLine()); // 컴퓨터 수
        conn = Integer.parseInt(br.readLine()); // 연결 수

        arr = new int[comCnt + 1][comCnt + 1];
        checked = new boolean[comCnt + 1];

        for (int i = 0; i < conn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            arr[com1][com2] = arr[com2][com1] = 1;
        }

        dfs(1);

        System.out.println(cnt - 1);

    }

    public static void dfs(int start) {
        checked[start] = true;
        cnt++;

        for (int i = 0; i <= comCnt; i++) {
            // 노드 i가 start와 연결되어 있고 아직 방문하지 않았다면, 노드 탐색
            // dfs 재귀적으로 호출
            if(arr[start][i] == 1 && !checked[i]) {
                dfs(i);
            }
        }
    }
}
