import java.util.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] moveBoard;
    static int[] dir = new int[5];
    static int max = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        board = new int[N][N];
        moveBoard = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                board[i][j] = s.nextInt();

        permutation(0);
        System.out.println(max);
    }

    static void permutation(int moved) {
        if(moved == 5) {
            for (int i = 0; i < N; i++)
                moveBoard[i] = board[i].clone();

            simulate();
            max = Math.max(max, Arrays.stream(moveBoard)
                    .flatMapToInt(Arrays::stream)
                    .max().orElse(0));
            return;
        }
        for(int i = 0; i < 4; i++) {
            dir[moved] = i+1;
            permutation(moved+1);
            dir[moved] = 0;
        }
    }

    static void simulate() {
        for(int d : dir) {
            if(d == 1) {
                for(int i = 0; i < N; i++) {
                    int index = 0, latest = 0;

                    for(int j = 0; j < N; j++) {
                        if(moveBoard[j][i] != 0) {
                            if(latest == moveBoard[j][i]) {
                                moveBoard[index - 1][i] = latest * 2;
                                moveBoard[j][i] = 0;
                                latest = 0;
                            }
                            else {
                                latest = moveBoard[j][i];
                                moveBoard[j][i] = 0;
                                moveBoard[index][i] = latest;
                                index++;
                            }
                        }
                    }
                }
            }
            if(d == 2) {
                for(int i = 0; i < N; i++) {
                    int index = N-1, latest = 0;

                    for(int j = N - 1; j >= 0; j--) {
                        if(moveBoard[i][j] != 0) {
                            if(latest == moveBoard[i][j]) {
                                moveBoard[i][index + 1] = latest * 2;
                                moveBoard[i][j] = 0;
                                latest = 0;
                            }
                            else {
                                latest = moveBoard[i][j];
                                moveBoard[i][j] = 0;
                                moveBoard[i][index] = latest;
                                index--;
                            }
                        }
                    }
                }
            }
            if(d == 3) {
                for(int i = 0; i < N; i++) {
                    int index = N-1, latest = 0;

                    for(int j = N - 1; j >= 0; j--) {
                        if(moveBoard[j][i] != 0) {
                            if(latest == moveBoard[j][i]) {
                                moveBoard[index + 1][i] = latest * 2;
                                moveBoard[j][i] = 0;
                                latest = 0;
                            }
                            else {
                                latest = moveBoard[j][i];
                                moveBoard[j][i] = 0;
                                moveBoard[index][i] = latest;
                                index--;
                            }
                        }
                    }
                }
            }
            if(d == 4) {
                for(int i = 0; i < N; i++) {
                    int index = 0, latest = 0;

                    for(int j = 0; j < N; j++) {
                        if(moveBoard[i][j] != 0) {
                            if(latest == moveBoard[i][j]) {
                                moveBoard[i][index - 1] = latest * 2;
                                moveBoard[i][j] = 0;
                                latest = 0;
                            }
                            else {
                                latest = moveBoard[i][j];
                                moveBoard[i][j] = 0;
                                moveBoard[i][index] = latest;
                                index++;
                            }
                        }
                    }
                }
            }
        }
    }
}