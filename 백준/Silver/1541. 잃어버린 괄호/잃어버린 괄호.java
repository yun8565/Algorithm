import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String equation = br.readLine();
        int sum = Integer.MAX_VALUE;

        for(String part : equation.split("-")) {
            int partSum = 0;
            for(String n : part.split("\\+"))
                partSum += Integer.parseInt(n);
            sum = sum == Integer.MAX_VALUE ? partSum : sum-partSum;
        }
        System.out.println(sum);
    }
}