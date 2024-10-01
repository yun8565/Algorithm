import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> sides = new ArrayList<>();

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < 6; i++) {
            int x = Integer.parseInt(br.readLine().split(" ")[1]);
            sides.add(x);
        }

        int index1 = 0, index2 = 0, max = 0;
        for(int i = 0; i < sides.size(); i++) {
            int side = sides.get(i);
            if(side > max) {
                index1 = i;
                index2 = sides.get((i+5)%6) > sides.get((i+1)%6) ? (i+5)%6 : (i+1)%6;
                max = side;
            }
        }

        int total = sides.get(index1) * sides.get(index2);
        int part = sides.get((index1+3)%6) * sides.get((index2+9)%6);
        System.out.println((total-part)*K);
    }
}