import java.util.*;

class Solution {
    Queue<String> answer = new PriorityQueue<>();
    List<String> routes = new ArrayList<>();
    HashMap<String, List<String>> flight = new HashMap<>();
    HashMap<Pair, Integer> visited = new HashMap<>();
    int N;

    public String[] solution(String[][] tickets) {
        N = tickets.length;
        for(String[] ticket : tickets) {
            Pair ticketPair = new Pair(ticket[0], ticket[1]);
            flight.putIfAbsent(ticket[0], new ArrayList<>());
            visited.putIfAbsent(ticketPair, 0);
            flight.get(ticket[0]).add(ticket[1]);
            visited.put(ticketPair, visited.getOrDefault(ticketPair, 0) + 1);
        }

        routes.add("ICN");
        dfs("ICN");
        String a = answer.peek().replaceAll("[\\[|\\]]","");
        return Arrays.stream(a.split(",")).map(String::trim).toArray(String[]::new);
    }

    void dfs(String start) {
        if(routes.size() == N+1) {
            answer.add(routes.toString());
            return;
        }
        if(!flight.containsKey(start))
            return;
        for(String dest : flight.get(start)) {
            Pair ticket = new Pair(start, dest);
            if(visited.containsKey(ticket) && visited.get(ticket)>0) {
                visited.put(ticket, visited.get(ticket)-1);
                routes.add(dest);
                dfs(dest);
                routes.remove(routes.size() - 1);
                visited.put(ticket, visited.get(ticket)+1);
            }
        }

    }

    class Pair {
        String from, to;
        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return from.equals(pair.from) && to.equals(pair.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}