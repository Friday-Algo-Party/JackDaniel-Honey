package B1181_단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
        }

        List<String> wordsList = new ArrayList<>(words);
        wordsList.sort(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()));

        for (String word : wordsList) {
            System.out.println(word);
        }

    }
}
