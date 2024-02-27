import java.util.*;

public class Main {

    static int m;
    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int p = s.nextInt();
        m = s.nextInt();

        for(int i = 0; i < p; i++) {
            int l = s.nextInt();
            String n = s.next();
            boolean matched = false;
            Player player = new Player(l,n);

            for(Room room : rooms) {
                if(Math.abs(room.level - l) <= 10 && !room.isFull()) {
                    room.players.add(player);
                    matched = true;
                    break;
                }
            }
            if(!matched)
                rooms.add(new Room(l, player));
        }

        for(Room room : rooms) {
            System.out.println(room.isFull() ? "Started!" : "Waiting!");
            room.players.stream().sorted(Comparator.comparing(o -> o.name))
                    .forEach(it -> System.out.println(it.level + " " + it.name));
        }
    }

    static class Room {
        int level;
        List<Player> players = new ArrayList<>();

        public Room(int level, Player player) {
            this.level = level;
            players.add(player);
        }

        public boolean isFull() {
            return this.players.size() == m;
        }
    }

    static class Player{
        int level;
        String name;

        public Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}