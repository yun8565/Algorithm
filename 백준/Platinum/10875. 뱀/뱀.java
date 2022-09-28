import java.util.*;

class path {
    coord start;
    coord end;
    long len;
    int dir;

    public path(coord start, coord end, long len, int dir) {
        this.start = start;
        this.end = end;
        this.len = len;
        this.dir = dir;
    }
}

class coord {
    // y = 세로 x = 가로
    long x, y;
    coord(long x, long y){
        this.x = x;
        this.y = y ;
    }
}

public class Main {

    static coord head;
    static long L;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        L = s.nextInt();
        int N = s.nextInt();

        // TODO: 뱀 이동 경로 (시작점부터 끝까지만) 저장하고

        // TODO: 가장 가까운 선분과의 차이를 빼기

        ArrayList<path> trace = new ArrayList<>();
        head = new coord(L, L);

        long t = 0;
        int d = 0;
        boolean flag = false;

        for (int i = 0; i <= N; i++) {
            int time;
            time = i == N ? Integer.MAX_VALUE: s.nextInt();

            long nearest;

            switch (d) {
                case 0: //오른쪽
                    nearest = 2 * L;
                    for (path p : trace) {
                        long tmp = check(p,time,d);
                        if (tmp >= 0) {
                            nearest = Math.min(nearest, tmp);
                            flag = true;
                        }
                    }
                    if(flag && nearest >= 0)
                        t += nearest - head.x;
                    if (!flag && head.x + time > 2 * L) {
                        t += 2 * L - head.x + 1;
                        flag = true;
                    }
                    trace.add(new path(head, new coord(head.x + time, head.y), time, d));
                    head = new coord(head.x + time, head.y);
                    break;
                case 1: //위쪽
                    nearest = 0;
                    for (path p : trace) {
                        long tmp = check(p,time,d);
                        if (tmp >= 0) {
                            nearest = Math.max(nearest, tmp);
                            flag = true;
                        }
                    }
                    if(flag && nearest >= 0)
                        t += head.y - nearest;
                    if (!flag && head.y - time < 0) {
                        t += head.y + 1;
                        flag = true;
                    }
                    trace.add(new path(head, new coord(head.x, head.y - time), time, d));
                    head = new coord(head.x, head.y-time);
                    break;
                case 2: //왼쪽
                    nearest = 0;
                    for (path p : trace) {
                        long tmp = check(p,time,d);
                        if (tmp >= 0) {
                            nearest = Math.max(nearest, tmp);
                            flag = true;
                        }
                    }
                    if(flag && nearest >= 0)
                        t += head.x - nearest;
                    if (!flag && head.x - time < 0) {
                        t += head.x + 1;
                        flag = true;
                    }
                    trace.add(new path(head, new coord(head.x - time, head.y), time, d));
                    head = new coord(head.x - time, head.y);
                    break;
                case 3: //아래쪽
                    nearest = 2 * L;
                    for (path p : trace) {
                        long tmp = check(p,time,d);
                        if (tmp >= 0) {
                            nearest = Math.min(nearest, tmp);
                            flag = true;
                        }
                    }
                    if(flag && nearest >= 0)
                        t += nearest - head.y;
                    if (!flag && head.y + time > 2 * L) {
                        t += 2 * L - head.y + 1;
                        flag = true;
                    }
                    trace.add(new path(head, new coord(head.x, head.y + time), time, d));
                    head = new coord(head.x, head.y + time);
                    break;
            }
            // 경로 겹치면
            if(flag || i == N) break;
            else t += time;

            d = s.next().equals("L") ? (d + 1) % 4 : (d - 1 == -1) ? 3 : d - 1;
        }
        System.out.println(t);
    }

    static long check(path p, int time, int dir) {
        if(dir == 0) {
            if((p.dir == 0) && (p.start.y == head.y) && (head.x < p.start.x) && (head.x + time >= p.start.x))
                return p.start.x;
            else if ((p.dir == 1) && (p.start.y >= head.y) && (p.end.y <= head.y) && (head.x < p.start.x) && (head.x + time >= p.start.x))
                return p.start.x;
            else if((p.dir == 2) && (p.start.y == head.y) && (head.x < p.end.x) && (head.x + time >= p.end.x))
                return p.end.x;
            else if ((p.dir == 3) && (p.start.y <= head.y) && (p.end.y >= head.y) && (head.x < p.start.x) && (head.x + time >= p.start.x))
                return p.start.x;
        }
        else if(dir == 1){
            if ((p.dir == 0) && (p.start.x <= head.x) && (p.end.x >= head.x) && (head.y > p.start.y) && (head.y - time <= p.start.y))
                return p.start.y;
            else if((p.dir == 1) && (p.start.x == head.x) && (head.y > p.start.y) && (head.y - time <= p.start.y))
                return p.start.y;
            else if ((p.dir == 2) && (p.start.x >= head.x) && (p.end.x <= head.x) && (head.y > p.start.y) && (head.y - time <= p.start.y))
                return p.start.y;
            else if((p.dir == 3) && (p.start.x == head.x) && (head.x < p.end.x) && (head.y - time >= p.end.x))
                return p.end.y;
        }
        else if(dir == 2){
            if((p.dir == 0) && (p.start.y == head.y) && (head.x > p.end.x) && (head.x - time <= p.end.x))
                return p.end.x;
            else if ((p.dir == 1) && (p.start.y >= head.y) && (p.end.y <= head.y) && (head.x > p.start.x) && (head.x - time <= p.start.x))
                return p.start.x;
            else if((p.dir == 2) && (p.start.y == head.y) && (head.x > p.start.x) && (head.x - time <= p.start.x))
                return p.start.x;
            else if ((p.dir == 3) && (p.start.y <= head.y) && (p.end.y >= head.y) && (head.x > p.start.x) && (head.x - time <= p.start.x))
                return p.start.x;
        }
        else if(dir == 3){
            if ((p.dir == 0) && (p.start.x <= head.x) && (p.end.x >= head.x) && (head.y < p.start.y) && (head.y + time >= p.start.y))
                return p.start.y;
            else if((p.dir == 1) && (p.start.x == head.x) && (head.y < p.end.y) && (head.y + time >= p.end.x))
                return p.end.y;
            else if ((p.dir == 2) && (p.start.x >= head.x) && (p.end.x <= head.x) && (head.y < p.start.y) && (head.y + time >= p.start.y))
                return p.start.y;
            else if((p.dir == 3) && (p.start.x == head.x) && (head.y < p.start.y) && (head.y + time >= p.start.x))
                return p.start.y;
        }
        return -1;
    }
}