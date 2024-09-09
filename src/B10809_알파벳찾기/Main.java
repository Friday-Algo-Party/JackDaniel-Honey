package B10809_알파벳찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];

        Arrays.fill(arr, -1);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;
            }
        }

        for(int val: arr) {
            System.out.print(val + " ");
        }

    }
}
