import java.util.*;

public class Main {
    static int[] max_heap;
    static int size = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        max_heap = new int[N];

        for(int i = 0; i < N; i++){
            int num = s.nextInt();
            if(num == 0) {
                if(size == 0) System.out.println(0);
                else System.out.println(delete());
            }
            else insert(num);
        }
    }

    static void insert(int item) {
        int i = ++size;
        while(i > 1 && item > max_heap[i/2]) {
            max_heap[i] = max_heap[i/2];
            i /= 2;
        }
        max_heap[i] = item;
    }

    static int delete() {
        int item = max_heap[1];
        int temp = max_heap[size--];

        int parent = 1, child = 2;

        while(child <= size) {
            if((child < size) && (max_heap[child] < max_heap[child+1]))
                child++;
            if(temp >= max_heap[child]) break;
            else{
                max_heap[parent] = max_heap[child];
                parent = child;
                child *= 2;
            }
        }
        max_heap[parent] = temp;
        return item;
    }

}
