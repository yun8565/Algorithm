import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //피신고인에 대한 신고자 목록 관리
        HashMap<String, Vector<String>> trace = new HashMap<String, Vector<String>>();
        //사용자별 신고당한 횟수 관리
        HashMap<String, Integer> count = new HashMap<String, Integer>();

        // 중복 값 없애기
        LinkedHashSet<String> reports = new LinkedHashSet<>(Arrays.asList(report));
        String[] reportNodup = reports.toArray(new String[0]);

        for(String s : reportNodup) {
            String[] tmp = s.split(" ");

            //신고 이력 존재하면 리스트에 추가, 없으면 새로 생성
            if(trace.containsKey(tmp[1])) {
                trace.get(tmp[1]).add(tmp[0]);
            }
            else{
                Vector<String> list = new Vector<String>();
                list.add(tmp[0]);
                trace.put(tmp[1], list);
            }
            count.put(tmp[1], count.getOrDefault(tmp[1], 0)+1);
        }

        for(int i = 0; i < id_list.length; i++){
            if(count.getOrDefault(id_list[i], 0) >= k){
                for(String s : trace.get(id_list[i]))
                    answer[Arrays.asList(id_list).indexOf(s)]++;
            }
        }
        return answer;
    }
}