import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Vector<String> ans = new Vector<>();
        HashMap<String, String> uidList = new HashMap<>();

        for(String s : record){
            String[] tmp = s.split(" ");

            if(tmp[0].equals("Change")){
                uidList.replace(tmp[1],tmp[2]);
                continue;
            }
            if(tmp[0].equals("Enter")){
                if(uidList.containsKey(tmp[1]))
                    uidList.replace(tmp[1],tmp[2]);
                else uidList.put(tmp[1],tmp[2]);
            }
            ans.add(tmp[0].equals("Enter") ? String.format("%s님이 들어왔습니다.",tmp[1]) : String.format("%s님이 나갔습니다.",tmp[1]));
        }

        for(int i = 0; i < ans.size(); i++){
            String[] tmp2 = ans.get(i).split("님");
            String uid = tmp2[0];
            ans.set(i, ans.get(i).replace(uid, uidList.get(uid)));
        }
        answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
}