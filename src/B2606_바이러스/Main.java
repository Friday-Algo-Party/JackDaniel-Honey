package B2606_바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int comCnt = Integer.parseInt(br.readLine()); // 컴퓨터 수
        int conn = Integer.parseInt(br.readLine()); // 연결 수

        boolean[] visited = new boolean[comCnt + 1]; // 감염 여부 추적
        ArrayList<Integer>[] network = new ArrayList[comCnt + 1]; // 컴퓨터 연결 상태 저장

        for (int i = 1; i <= comCnt; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < conn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());
            network[com1].add(com2);
            network[com2].add(com1);
//            System.out.println(Arrays.toString(network));
        }

        // 초기 설정 (컴퓨터 1번 바이러스 감염)
        visited[1] = true;
        // list는 현재 감염된 컴퓨터 저장
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        while (true) {
            ArrayList<Integer> newInfected = new ArrayList<>();

            for (int infected : list) {
                // 현재 감염된 컴퓨터에 연결된 이웃 컴퓨터들 검사
                for (int neighbor : network[infected]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        newInfected.add(neighbor);
                    }
                }
            }

            if (newInfected.isEmpty()) {
                break;
            }

            list.addAll(newInfected);
        }

        System.out.println(list.size() - 1);
    }
}
