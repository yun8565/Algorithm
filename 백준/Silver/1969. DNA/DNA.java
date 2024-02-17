import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();
        List<Character> nucleotides = List.of('A', 'C', 'G', 'T');

        int[][] count = new int[M][4];
        StringBuilder sb = new StringBuilder();
        int hDist = 0;

        for(int i = 0; i < N; i++) {
            String dna = s.next();
            for(int k = 0; k < M; k++) {
                count[k][nucleotides.indexOf(dna.charAt(k))]++;
            }
        }

        for(int i = 0; i < M; i++) {
            int max = 0;
            int index = 0;
            for(int k = 0; k < 4; k++) {
                if(max < count[i][k]) {
                    max = count[i][k];
                    index = k;
                }
            }
            sb.append(nucleotides.get(index));
            hDist += Arrays.stream(count[i]).sum() - max;
        }

        System.out.println(sb.toString());
        System.out.println(hDist);
    }
}