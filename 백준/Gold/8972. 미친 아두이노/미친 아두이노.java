import java.util.*;

public class Main {

    static int R,C;
    static char[][] map;
    static int[] dx = {0,1,1,1,0,0,0,-1,-1,-1};
    static int[] dy = {0,-1,0,1,-1,0,1,-1,0,1};
    static Arduino I;
    static List<Arduino> mads = new ArrayList<>();
    static List<Arduino> exploded = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        R = s.nextInt();
        C = s.nextInt();

        map = new char[R][C];

        for(int i = 0; i < R; i++) {
            String input = s.next();
            for(int j = 0; j < C; j++) {
                char c = input.charAt(j);
                if(c == 'I')
                    I = new Arduino(i,j);
                if(c == 'R')
                    mads.add(new Arduino(i,j));
                map[i][j] = c;
            }
        }

        String op = s.next();
        int time = 0;
        while(time < op.length() && !flag) {
            int dir = op.charAt(time) - '0';
            I.move(dir);
            map[I.x][I.y] = 'I';
            flag = simulate();

            time++;
        }

        if(flag)
            System.out.println("kraj " + time);
        else
            printMap();
    }

    static void printMap() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
    }

    static boolean simulate() {
        exploded.clear();
        for(Arduino a : mads) {
            int minDist = 1000;
            int optDir = 0;

            for(int dir = 1; dir <= 9; dir++) {
                int dist = Math.abs(I.x-(a.x+dx[dir])) + Math.abs(I.y-(a.y+dy[dir]));
                if(minDist > dist) {
                    minDist = dist;
                    optDir = dir;
                }
            }
            a.move(optDir);
        }

        for(Arduino a : mads) {
            if(a.x == I.x && a.y == I.y)
                return true;
            if(map[a.x][a.y] == 'R')
                exploded.add(new Arduino(a.x,a.y));
            if(map[a.x][a.y] == '.')
                map[a.x][a.y] = 'R';
        }

        for(Arduino e : exploded) {
            map[e.x][e.y] = '.';
            mads.removeIf(a -> a.x == e.x && a.y == e.y);
        }
        return false;
    }

    static class Arduino {
        int x,y;

        public Arduino(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void move(int dir) {
            map[this.x][this.y] = '.';
            this.x += dx[dir];
            this.y += dy[dir];
        }
    }
}