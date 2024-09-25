import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String file = br.readLine();

            String ext = file.split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(ext -> System.out.println(ext.getKey() + " " + ext.getValue()));
    }
}