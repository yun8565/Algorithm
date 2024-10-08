import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(String s : br.readLine().split(" ")) {
                list.add(Integer.parseInt(s));
            }
        }
        Collections.sort(list);
        System.out.println(list.get(N*N - N));
    }
}