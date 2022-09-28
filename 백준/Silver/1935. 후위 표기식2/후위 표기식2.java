import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double result = 0;
        int N = Integer.parseInt(br.readLine());

        int[] val = new int[N];
        Stack<Double> stack = new Stack<>();

        String postfix = br.readLine();

        for(int i = 0; i < N; i++)
            val[i] = Integer.parseInt(br.readLine());

        for(char c : postfix.toCharArray()){
            if(Character.isAlphabetic(c))
                stack.push((double)val[c-65]);
            else{
                switch(c){
                    case '*': stack.push(stack.pop() * stack.pop());
                        break;
                    case '+': stack.push(stack.pop() + stack.pop());
                        break;
                    case '-':
                        double n1 = stack.pop(), n2 = stack.pop();
                        stack.push(n2 - n1);
                        break;
                    case '/':
                        double n3 = stack.pop(), n4 = stack.pop();
                        stack.push(n4 / n3);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.peek());
    }
}