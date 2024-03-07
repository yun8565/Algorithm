import java.util.*;

public class Main {

    static char[][] map;
    static char[][] copyMap;
    static boolean success;
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Pair> selected = new ArrayList<>();
    static List<Pair> teachers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();

        map = new char[N][N];
        copyMap = new char[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                char c = s.next().charAt(0);
                if(c == 'T')
                    teachers.add(new Pair(i,j));
                map[i][j] = c;
            }
        }

        dfs(0 ,0);

        System.out.println(success ? "YES" : "NO");
    }

    static void dfs(int x, int y) {
        if(selected.size() == 3) {
            success |= simulate();
            return;
        }
        for(int i = x; i < N; i++) {
            for(int j = y; j < N; j++) {
                if(j == N-1)
                    y = 0;
                if(map[i][j] == 'X') {
                    selected.add(new Pair(i,j));
                    if(j == N-1)
                        dfs(i+1, 0);
                    else
                        dfs(i, j+1);
                    selected.remove(selected.size()-1);
                }
            }
        }
    }

    static boolean simulate() {
        for(int i = 0; i < N; i++)
            copyMap[i] = map[i].clone();

        for(Pair p : selected)
            copyMap[p.x][p.y] = 'O';

        for(Pair t : teachers) {
            for(int i = 0; i < 4; i++) {
                int x = t.x;
                int y = t.y;
                while(x >= 0 && y >= 0 && x < N && y < N) {
                    if(map[x][y] == 'S')
                        return false;
                    if(copyMap[x][y] == 'O')
                        break;
                    x += dx[i];
                    y += dy[i];
                }
            }
        }
        return true;
    }

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}