import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public long solution(String expression) {
        long answer = 0;

        String[] patterns = {"*+-", "*-+", "+*-", "+-*", "-*+", "-+*"};

        ArrayList<Long> num = Arrays.stream(expression.split("[^0-9]"))
                .map(Long::parseLong).collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> ops = Arrays.stream(expression.split("[0-9]"))
                .filter(op -> !op.isBlank())
                .collect(Collectors.toCollection(ArrayList::new));

        for(String op : patterns) {

            ArrayList<Long> tempNum = (ArrayList<Long>) num.clone();
            ArrayList<String> tempOp= (ArrayList<String>) ops.clone();

            switch (op.charAt(0)){
                case '*' -> calculate(tempNum, tempOp, "*");
                case '+' -> calculate(tempNum, tempOp, "+");
                case '-' -> calculate(tempNum, tempOp, "-");
            }
            switch (op.charAt(1)){
                case '*' -> calculate(tempNum, tempOp, "*");
                case '+' -> calculate(tempNum, tempOp, "+");
                case '-' -> calculate(tempNum, tempOp, "-");
            }
            switch (op.charAt(2)){
                case '*' -> calculate(tempNum, tempOp, "*");
                case '+' -> calculate(tempNum, tempOp, "+");
                case '-' -> calculate(tempNum, tempOp, "-");
            }

            answer = Math.max(answer, Math.abs(tempNum.get(0)));
        }

        return answer;
    }

    public void calculate(ArrayList<Long> num, ArrayList<String> ops, String op) {
        for(Iterator<String> it = ops.iterator(); it.hasNext();) {
            String s = it.next();
            if(s.equals(op)){
                int index = ops.indexOf(s);
                long result = switch (s){
                    case "*" -> num.get(index) * num.get(index+1);
                    case "+" -> num.get(index) + num.get(index+1);
                    case "-" -> num.get(index) - num.get(index+1);
                    default -> throw new IllegalStateException("Unexpected value");
                };
                num.set(index, result);
                num.remove(index+1);
                it.remove();
            }
        }
    }
}