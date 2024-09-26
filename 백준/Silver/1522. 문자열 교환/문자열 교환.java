import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.replaceAll("b","").length();
        int min = Integer.MAX_VALUE;
        int count = s.substring(0,len).replaceAll("b","").length();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt((i+len)%s.length()) == 'a')
                count++;
            if(s.charAt(i) == 'a')
                count--;
            
            min = Math.min(min, len-count);
        }
        
        System.out.println(min);
    }
}