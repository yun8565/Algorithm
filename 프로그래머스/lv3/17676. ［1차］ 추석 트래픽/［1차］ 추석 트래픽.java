import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Solution {
    class log {
        long start;
        long finish;

        public log(long s, long f){
            this.start = s;
            this.finish = f;
        }
    }

    public int solution(String[] lines) throws ParseException {
        int answer = 0;
        //중복된 로그를 고려안했다...

        ArrayList<log> logs = new ArrayList<>();
        //HashMap<Long, Long> logs = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

        for(String log : lines) {
            String tmp = log.split(" ")[0] + " " + log.split(" ")[1];
            double timeTaken =Double.parseDouble(log.split(" ")[2].split("s")[0]) * 1000;
            long finish = simpleDateFormat.parse(tmp).getTime();
            logs.add(new log(finish - (long)timeTaken + 1, finish));
        }

        for(log l : logs) {
            long start = l.start;
            long finish = l.finish;

            // TODO: 시작하는 부분부터 1초까지 겹치는 로그 세기
            int count = 1;
            for(log ll : logs) {
                // 겹치는 조건:
                // 1. start가 중간에 껴있다.
                // 2. finish가 중간에 껴있다.
                // 3. start와 finish가 밖에있다.

                long tmpStart = ll.start;
                long tmpFinish = ll.finish;

                if(l.equals(ll))
                    continue;
                if(start <= tmpStart && tmpStart <= start+999){
                    count++;
                    continue;
                }
                if(start <= tmpFinish && tmpFinish <= start+999){
                    count++;
                    continue;
                }
                if(tmpStart < start && tmpFinish > start+999){
                    count++;
                    continue;
                }
            }
            answer = Math.max(answer, count);

            count = 1;
            for(log ll : logs) {
                // 겹치는 조건:
                // 1. start가 중간에 껴있다.
                // 2. finish가 중간에 껴있다.
                // 3. start와 finish가 밖에있다.

                long tmpStart = ll.start;
                long tmpFinish = ll.finish;

                if(l.equals(ll))
                    continue;
                if(finish <= tmpStart && tmpStart <= finish+999){
                    count++;
                    continue;
                }
                if(finish <= tmpFinish && tmpFinish <= finish+999){
                    count++;
                    continue;
                }
                if(tmpStart < finish && tmpFinish > finish+999){
                    count++;
                    continue;
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}