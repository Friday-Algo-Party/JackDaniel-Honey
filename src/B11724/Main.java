package B11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visitedFlag;
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visitedFlag = new boolean[N + 1];
        graph = new ArrayList<>();

        // 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>()); // 각 노드에 연결된 노드들을 담을 빈 리스트 생성
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 모든 노드를 확인하여 연결되지 않은 요소 탐색
        for(int i = 1; i <= N; i++) {
            if(!visitedFlag[i]) {
                bfs(i);
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(int point) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(point);
        visitedFlag[point] = true;

        while(!queue.isEmpty()) {
            int target = queue.poll();
            for (int node : graph.get(target)) {
                if(!visitedFlag[node]) {
                    queue.offer(node);
                    visitedFlag[node] = true;
                }
            }
        }
        cnt++;
    }
}
