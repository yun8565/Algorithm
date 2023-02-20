import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 트럭의 수
        int w = sc.nextInt(); // 다리의 길이
        int L = sc.nextInt(); // 다리가 버틸 수 있는 최대 하중

        Queue<Integer> q = new LinkedList<>(); // 다리 위에 있는 트럭을 저장하는 큐
        int[] truck = new int[n]; // 각 트럭의 무게를 저장하는 배열
        for (int i = 0; i < n; i++) {
            truck[i] = sc.nextInt();
        }

        int time = 0; // 걸리는 시간
        int weight = 0; // 다리 위에 있는 트럭의 무게

        for (int i = 0; i < n; i++) {
            while (true) {
                // 큐가 비어있는 경우
                if (q.isEmpty()) {
                    q.offer(truck[i]); // 트럭을 다리에 올림
                    time++; // 1초 추가
                    weight += truck[i]; // 다리 위에 있는 트럭의 무게 추가
                    break;
                }
                // 큐의 맨 앞에 있는 트럭이 다리를 건넜을 경우
                if (q.size() == w) {
                    weight -= q.poll(); // 다리에서 트럭을 내림
                } else {
                    // 다음 트럭이 다리에 올라갈 수 있는 경우
                    if (weight + truck[i] <= L) {
                        q.offer(truck[i]); // 트럭을 다리에 올림
                        time++; // 1초 추가
                        weight += truck[i]; // 다리 위에 있는 트럭의 무게 추가
                        break;
                    } else {
                        // 다음 트럭이 다리에 올라갈 수 없는 경우
                        q.offer(0); // 다리 위에 있는 트럭의 자리를 비움
                        time++; // 1초 추가
                    }
                }
            }
        }
        // 모든 트럭이 다리를 건넜을 경우의 시간을 계산하여 출력
        System.out.println(time + w);
    }
}
