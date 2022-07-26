import java.util.*;

public class Main {
    static int[] min_heap;
    static int size = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        min_heap = new int[N];

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
        while(i > 1 && item < min_heap[i/2]) {
            min_heap[i] = min_heap[i/2];
            i /= 2;
        }
        min_heap[i] = item;
    }

    static int delete() {
        int item = min_heap[1];
        int temp = min_heap[size--];

        int parent = 1, child = 2;

        while(child <= size) {
            if((child < size) && (min_heap[child] > min_heap[child+1]))
                child++;
            if(temp <= min_heap[child]) break;
            else{
                min_heap[parent] = min_heap[child];
                parent = child;
                child *= 2;
            }
        }
        min_heap[parent] = temp;
        return item;
    }

}
