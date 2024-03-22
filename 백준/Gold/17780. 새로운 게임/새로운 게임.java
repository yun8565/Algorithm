import java.util.*;

public class Main {

    static int N;
    static final int EMPTY = 0;
    static final int RED = 1;
    static final int BLUE = 2;
    static Board[][] chessBoard;
    static List<Chess> chessList = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        int K = s.nextInt();
        int turn = 1;

        chessBoard = new Board[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                chessBoard[i][j] = new Board(s.nextInt());

        for(int i = 1; i <= K; i++) {
            int x = s.nextInt()-1;
            int y = s.nextInt()-1;
            int dir = s.nextInt()-1;
            Chess chess = new Chess(x,y,i,dir);
            chessList.add(chess);
            chessBoard[x][y].on.add(chess);
        }

        flag : while(turn <= 1000) {
            for(Chess c : chessList) {
                if(c.canMove()) {
                    int nx = c.x + dx[c.dir];
                    int ny = c.y + dy[c.dir];

                    if(canGo(nx,ny)) {
                        if(chessBoard[nx][ny].type != BLUE) {
                            if(chessBoard[nx][ny].type == RED)
                                Collections.reverse(chessBoard[c.x][c.y].on);
                            chessBoard[c.x][c.y].move(nx,ny);
                            if(chessBoard[nx][ny].on.size() >= 4)
                                break flag;
                        }
                    }
                    if(!canGo(nx,ny) || chessBoard[nx][ny].type == BLUE) {
                        c.dir = c.dir % 2 == 0 ? c.dir + 1 : c.dir - 1;
                        int nX = c.x + dx[c.dir];
                        int nY = c.y + dy[c.dir];
                        if (canGo(nX, nY) && chessBoard[nX][nY].type != BLUE) {
                            if (chessBoard[nX][nY].type == RED)
                                Collections.reverse(chessBoard[c.x][c.y].on);
                            chessBoard[c.x][c.y].move(nX, nY);
                            if(chessBoard[nX][nY].on.size() >= 4)
                                break flag;
                        }
                    }
                }
            }
            turn++;
        }

        System.out.println(turn > 1000 ? -1 : turn);
    }

    static boolean canGo(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Chess {
        int x, y, num, dir;
        public Chess(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
        public boolean canMove() {
            return chessBoard[x][y].on.indexOf(this) == 0;
        }
    }

    static class Board {
        int type;
        List<Chess> on = new ArrayList<>();
        public Board(int type) {
            this.type = type;
        }
        public void move(int x, int y) {
            for(Chess c : chessList) {
                if (on.stream().anyMatch(it -> it.num == c.num)) {
                    c.x = x;
                    c.y = y;
                }
            }
            chessBoard[x][y].on.addAll(this.on);
            on.clear();
        }
    }
}