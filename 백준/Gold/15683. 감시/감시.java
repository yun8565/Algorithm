import java.util.*;

class coord {
    int x;
    int y;

    public coord(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class Main {
    static int[][] map;
    static Map<coord, Integer> cctv;
    static List<coord> cctvKeySet;
    static int N;
    static int M;
    static int max = 0;

    static int[][] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        cctv = new HashMap<>();


        N = s.nextInt();
        M = s.nextInt();

        map = new int[N][M];
        visited = new int[N][M];
        int square = N*M;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int num = s.nextInt();
                if(num > 0) {
                    square--;
                    if(num < 6)
                        cctv.put(new coord(j, i), num);
                    visited[i][j] = 99;
                }
                map[i][j] = num;
            }
        }

        cctvKeySet = new ArrayList<>(cctv.keySet());
        //cctv 유형 기준 내림차순 정렬 (감시할 수 있는 방향이 많은 것 부터 확인) 그냥..
        cctvKeySet.sort(((o1, o2) -> cctv.get(o2).compareTo(cctv.get(o1))));

        check(1, 0);

        System.out.println(square - max);
    }

    static void check(int depth, int total){
        if(depth == cctv.size()+1)
            max = Math.max(max, total);
        else {
            coord c = (coord) cctvKeySet.toArray()[depth-1];
            int type = cctv.get(c);
            if(type == 1){
                for (int dir = 1; dir <= 4; dir++) {
                    int local_total = monitor(true, dir, c.x, c.y, depth);
                    check(depth + 1, total + local_total);

                    monitor(false, dir, c.x, c.y, depth);
                }
            }
            else if(type == 2){
                for (int dir = 1; dir <= 2; dir++) {
                    int local_total = monitor(true, dir, c.x, c.y, depth) + monitor(true,dir+2, c.x, c.y, depth);
                    check(depth + 1, total + local_total);

                    monitor(false, dir, c.x, c.y, depth);
                    monitor(false, dir+2, c.x, c.y, depth);
                }
            }
            else if(type == 3){
                for (int dir = 1; dir <= 4; dir++) {
                    int local_total = monitor(true,dir, c.x, c.y, depth) + monitor(true,(dir%4)+1, c.x, c.y, depth);
                    check(depth + 1, total + local_total);

                    monitor(false, dir, c.x, c.y, depth);
                    monitor(false, (dir%4)+1, c.x, c.y, depth);
                }
            }
            else if(type == 4){
                for (int dir = 1; dir <= 4; dir++) {
                    int local_total = monitor(true, dir, c.x, c.y, depth) + monitor(true,(dir%4)+1, c.x, c.y, depth)
                            + monitor(true,(dir<3)?(dir+2):(dir-2), c.x, c.y, depth);
                    check(depth + 1, total + local_total);

                    monitor(false, dir, c.x, c.y, depth);
                    monitor(false, (dir%4)+1, c.x, c.y, depth);
                    monitor(false, (dir<3)?(dir+2):(dir-2), c.x, c.y, depth);
                }
            }
            else{
                int local_total = monitor(true,1,c.x,c.y, depth)+monitor(true,2,c.x,c.y, depth)
                        +monitor(true,3,c.x,c.y, depth)+monitor(true,4,c.x,c.y, depth);
                check(depth+1, total + local_total);
                for(int k = 1; k <= 4; k++)
                    monitor(false, k, c.x, c.y, depth);
            }

        }
    }

    static int monitor(boolean flag, int dir, int x, int y, int depth) {
        int cnt = 0;
        //상
        if(dir == 1 && y > 0){
            for(int i = y-1; i >= 0 && map[i][x] < 6; i--){
                if(flag && visited[i][x] == 0) {
                    cnt++;
                    visited[i][x] = depth;
                }
                if(!flag && visited[i][x] == depth)
                    visited[i][x] = 0;
            }
        }
        //우
        else if(dir == 2 && x < M-1) {
            for(int i = x+1; i < M && map[y][i] < 6; i++){
                if(flag && visited[y][i] == 0){
                    cnt++;
                    visited[y][i] = depth;
                }
                if(!flag && visited[y][i] == depth)
                    visited[y][i] = 0;
            }
        }
        //하
        else if(dir == 3 && y < N-1){
            for(int i = y+1; i < N && map[i][x] < 6; i++){
                if(flag && visited[i][x] == 0) {
                    cnt++;
                    visited[i][x] = depth;
                }
                if(!flag && visited[i][x] == depth)
                    visited[i][x] = 0;
            }
        }
        //좌
        else if(dir == 4 && x > 0){
            for(int i = x - 1; i >= 0 && map[y][i] < 6; i--){
                if(flag && visited[y][i] == 0){
                    cnt++;
                    visited[y][i] = depth;
                }
                if(!flag && visited[y][i] == depth)
                    visited[y][i] = 0;
            }
        }
        return cnt;
    }
}
