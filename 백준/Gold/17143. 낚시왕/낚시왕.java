import java.util.*;

public class Main {

    static int R,C;
    static int total = 0;
    static Queue<Shark>[][] map;
    static Queue<Shark> q = new LinkedList<>();
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        R = s.nextInt();
        C = s.nextInt();
        int M = s.nextInt();

        map = new Queue[R+1][C+1];

        for(int i = 1; i <= R; i++)
            for(int j = 1; j <= C; j++)
                map[i][j] = new PriorityQueue<>((o1, o2) -> o1.size - o2.size);


        for(int i = 0; i < M; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            int speed = s.nextInt();
            int dir = s.nextInt();
            int size = s.nextInt();

            speed = speed % ((dir < 3 ? R-1 : C-1) * 2);

            map[x][y].add(new Shark(x,y,speed,dir,size));
        }

        for(int i = 1; i <= C; i++) {
            catchClosest(i);
            simulate();
        }

        System.out.println(total);
    }

    static void catchClosest(int fisherman) {
        for(int i = 1; i <= R; i++) {
            if(!map[i][fisherman].isEmpty()) {
                total += map[i][fisherman].poll().size;
                break;
            }
        }
    }

    static void simulate() {
        for(int i = 1; i <= R; i++) {
            for(int j = 1; j <= C; j++) {
                if(!map[i][j].isEmpty()) {
                    Shark s = map[i][j].poll();
                    s.move();
                    q.add(s);
                }
            }
        }

        while(!q.isEmpty()) {
            Shark shark = q.poll();
            int x = shark.x;
            int y = shark.y;

            map[x][y].add(shark);
            if(map[x][y].size() > 1) {
                while(map[x][y].size() > 1)
                    map[x][y].poll();
            }
        }
    }

    static class Shark {
        int x,y,speed,dir,size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }

        public void move() {
            int dist = speed;
            while(dist-- > 0) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (isIn(nx, ny)) {
                    x = nx;
                    y = ny;
                } else {
                    dir = (dir + (dir % 2 == 0 ? 4 : 1)) % 5;
                    x += dx[dir];
                    y += dy[dir];
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 1 && y >= 1 && x <= R && y <= C;
    }
}