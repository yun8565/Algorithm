import java.util.*;

public class Main {

    static int[][] map;
    static int N, satScore = 0;
    static List<Pair>[] count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        N = s.nextInt();
        count = new List[5];
        map = new int[N][N];

        for(int i = 0; i < 5; i++)
            count[i] = new ArrayList<>();

        for(int i = 0; i < N*N; i++) {
            int num = s.nextInt();
            int like1 = s.nextInt();
            int like2 = s.nextInt();
            int like3 = s.nextInt();
            int like4 = s.nextInt();

            students.add(new Student(num, like1, like2, like3, like4));
        }

        for(Student student : students) {
            allocate(student);
        }

        getScore();
        System.out.println(satScore);
    }

    static void getScore() {
        for(Student student : students) {
            int cnt = 0;
            int x = student.p.x;
            int y = student.p.y;

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(isIn(nx,ny) && student.likes(map[nx][ny]))
                    cnt++;
            }
            satScore += cnt == 0 ? 0 : Math.pow(10, cnt-1);
        }
    }

    static void allocate(Student student) {
        for(int i = 0; i < 5; i++)
            count[i].clear();

        int max = 0;

        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(map[x][y] == 0) {
                    int likeCnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (isIn(nx, ny) && student.likes(map[nx][ny]))
                                likeCnt++;
                    }
                    count[likeCnt].add(new Pair(x,y));
                    max = Math.max(max, likeCnt);
                }
            }
        }

        if(count[max].size() > 1) {
            int maxEmpty = 0;
            Pair opt = count[max].get(0);

            for(Pair p : count[max]) {
                int emptyCnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = p.x + dx[d];
                    int ny = p.y + dy[d];

                    if (isIn(nx, ny) && map[nx][ny] == 0)
                        emptyCnt++;
                }
                if(maxEmpty < emptyCnt) {
                    maxEmpty = emptyCnt;
                    opt = p;
                }
            }
            map[opt.x][opt.y] = student.num;
            student.p = opt;
        }
        else {
            map[count[max].get(0).x][count[max].get(0).y] = student.num;
            student.p = count[max].get(0);
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    static class Student {
        int num;
        Pair p;
        List<Integer> likeStudents;

        public Student(int num, int like1, int like2, int like3, int like4) {
            this.num = num;
            likeStudents = List.of(like1, like2, like3, like4);
        }

        public boolean likes(int s) {
            return likeStudents.stream().anyMatch(it -> it == s);
        }
    }

    static class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}