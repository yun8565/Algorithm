class Solution {

    static final int MAX = 24 * 60 + 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[MAX];

        for(String[] time : book_time) {
            int start = toMinutes(time[0]);
            int end = toMinutes(time[1]);

            rooms[start] += 1;
            rooms[end + 10] += -1;
        }

        for(int i = 1; i < MAX; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }

    public int toMinutes(String time) {
        return (Integer.parseInt(time.split(":")[0]))*60 + (Integer.parseInt(time.split(":")[1]));
    }
}