import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : scoville)
            pq.add(i);

        while(pq.peek() < K){
            if(pq.peek() < K && pq.size() == 1)
                return -1;
            pq.add(pq.poll() + (pq.poll() * 2));
            cnt++;
        }

        return cnt;
    }
}