package B1260_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int N = 0; // 정점의 개수 N
    public static int M = 0; // 간선의 개수 M
    public static int V = 0; // 탐색 시작 정점의 번호 V
    public static int node1 = 0;
    public static int node2 = 0;

    public static boolean[] visitedFlag;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());

        arr = new int[1001][1001];
        visitedFlag = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st2.nextToken());
            node2 = Integer.parseInt(st2.nextToken());
            // 양방향 연결
            arr[node1][node2] = arr[node2][node1] = 1;
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visitedFlag, false);
        bfs(V);
    }

    public static void dfs (int point) {
        visitedFlag[point] = true;
        System.out.print(point + " ");

        for (int i = 1; i <= N; i++) {
            if(arr[point][i] == 1 && !visitedFlag[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(point); // queue에 넣는다
        visitedFlag[point] = true;

        while(!queue.isEmpty()) {
            int target = queue.poll(); // 빼낸다
            System.out.print(target + " ");

            for (int i = 1; i < arr.length; i++) {
                if (arr[target][i] == 1 && !visitedFlag[i]) {
                    queue.add(i);
                    visitedFlag[i] = true;
                }
            }
        }
    }
}
