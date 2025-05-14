import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];

    public static void main(String[] args) throws IOException {
        
        // 默认为小根堆，要使用大根堆需要自定义比较器
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);

        out.println(heap.size());
        while(!heap.isEmpty()) {
            out.println(heap.poll());
        }

        out.flush();
        out.close();
        reader.close();
    }
}
