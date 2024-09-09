package B1260_BFS와DFS;

import java.io.*;
import java.util.*;

public class Main {

    public static int N = 0; // 정점의 개수 N
    public static int M = 0; // 간선의 개수 M
    public static int V = 0; // 탐색 시작 정점의 번호 V
    public static int node1 = 0;
    public static int node2 = 0;

    public static boolean[] visitedFlag;
    public static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());

        visitedFlag = new boolean[N + 1];

        graph = new ArrayList<ArrayList<Integer>>();

        // 리스트 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st2.nextToken());
            node2 = Integer.parseInt(st2.nextToken());
            // 양방향 연결
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
//			System.out.println(graph);
        }

        // 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것부터 방문 -> sort
        for(int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visitedFlag, false);
        bfs(V);
    }

    public static void dfs(int point) {
        visitedFlag[point] = true;
        System.out.print(point + " ");

        for (int node : graph.get(point)) {
            if(!visitedFlag[node]) {
                dfs(node);
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

            for (int node : graph.get(target)) {
                if(!visitedFlag[node]) {
                    queue.offer(node);
                    visitedFlag[node] = true;
                }
            }
        }
    }
}
