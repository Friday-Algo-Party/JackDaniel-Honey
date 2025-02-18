package B1541_잃어버린괄호_v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;

        String[] strs = str.split("-");
        String[] before = strs[0].split("\\+");
        for (String num: before) {
            answer += Integer.parseInt(num);
        }

        for (int i = 1; i < strs.length; i++) {
            String[] after = strs[i].split("\\+");
            for (String num: after) {
                answer -= Integer.parseInt(num);
            }
        }
        System.out.println(answer);
    }
}
