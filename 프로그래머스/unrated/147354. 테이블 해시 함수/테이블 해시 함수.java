import java.util.*;
import java.util.stream.Collectors;


class Solution {

    static int Col;
    static List<Tuple> sorted;

    static class Tuple implements Comparable<Tuple>{
        int[] data;

        public Tuple(int[] data) {
            this.data = data;
        }

        @Override
        public int compareTo(Tuple o) {
            if(this.data[Col] < o.data[Col])
                return -1;
            else if(this.data[Col] > o.data[Col])
                return 1;
            else {
                if(this.data[0] > o.data[0])
                    return -1;
                else if(this.data[0] < o.data[0])
                    return 1;
                else return 0;
            }
        }
    }

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Col = col-1;

        sorted = new ArrayList<>();

        for(int[] tuple : data)
            sorted.add(new Tuple(tuple));

        sorted = sorted.stream().sorted().collect(Collectors.toList());

        for(int i = row_begin; i <= row_end; i++)
            answer ^= getS_i(i);

        return answer;
    }

    public int getS_i(int i) {
        int sum = 0;
        for(int num : sorted.get(i-1).data)
            sum += num % i;
        return sum;
    }
}