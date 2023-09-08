import java.util.*;

public class Main {

    static List<Pair> places = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        while(t-- > 0) {
            int n = s.nextInt();
            visited = new boolean[n+2];

            for(int i = 0; i < n+2; i++) {
                int x = s.nextInt();
                int y = s.nextInt();
                places.add(new Pair(x,y));
            }

            System.out.println(bfs() ? "happy" : "sad");
            places.clear();
        }
    }

    static boolean bfs() {
        Queue<Pair> q = new LinkedList<>();
        q.add(places.get(0));
        visited[0] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();

            if(cur.x == places.get(places.size()-1).x && cur.y == places.get(places.size()-1).y)
                return true;

            for(int i = 0; i < places.size(); i++) {
                if(!visited[i] && reachable(cur, places.get(i))) {
                    visited[i] = true;
                    q.add(places.get(i));
                }
            }
        }
        return false;
    }

    static boolean reachable(Pair from, Pair to) {
        return (Math.abs(from.x - to.x) + Math.abs(from.y - to.y)) <= 1000;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}