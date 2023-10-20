import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String input = br.readLine();
            if(input.equals("end"))
                break;
            System.out.println(validate(input) ? "valid" : "invalid");
        }
    }

    static boolean validate(String board) {
        int xCount = (int)board.chars().filter(c -> c=='X').count();
        int oCount = (int)board.chars().filter(c -> c=='O').count();

        if(check(board, 'X') && check(board, 'O'))
            return false;

        if(xCount + oCount == 9) {
            if(xCount - oCount != 1)
                return false;
            if(check(board, 'O'))
                return false;
        }
        else {
            if(check(board, 'X') && xCount - oCount != 1)
                return false;
            if(check(board, 'O') && xCount != oCount)
                return false;
            if(!check(board, 'X') && !check(board, 'O'))
                return false;
        }
        return true;
    }

    static boolean check(String board, char c) {
        for(int i = 0; i < 3; i++) {
            int xCount = 0;
            int yCount = 0;
            for (int j = 0; j < 3; j++) {
                if(board.charAt(i * 3 + j) == c)
                    xCount++;
                if(board.charAt(j*3 + i) == c)
                    yCount++;
            }
            if(xCount == 3 || yCount == 3)
                return true;
        }
        if(board.charAt(0) == c && board.charAt(4) == c && board.charAt(8) == c)
            return true;
        if(board.charAt(2) == c && board.charAt(4) == c && board.charAt(6) == c)
            return true;

        return false;
    }
}