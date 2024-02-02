import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int[] word = new int[26];
        int similar = 0;

        String first = s.next();

        for(int i = 0; i < N-1; i++) {
            int same = 0;
            for(int k = 0; k < first.length(); k++)
                word[first.charAt(k)-'A']++;

            String next = s.next();
            for(int l = 0; l < next.length(); l++) {
                int index = next.charAt(l)-'A';
                if(word[index] > 0) {
                    same++;
                    word[index]--;
                }
            }
            if(first.length() == next.length() && (first.length() == same || first.length()-1==same))
                similar++;
            else if(first.length() == next.length()-1 && next.length()-1 == same)
                similar++;
            else if(first.length() == next.length()+1 && next.length() == same)
                similar++;
        }

        System.out.println(similar);
    }
}
