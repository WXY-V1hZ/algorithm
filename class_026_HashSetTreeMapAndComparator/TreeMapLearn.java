import java.io.*;
import java.util.*;

public class TreeMapLearn {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];

    public static void main(String[] args) throws IOException {
        
        // 最好直接声明为 TreeMap 类型，而不是 Map，因为 ceilingKey floorKey 是TreeMap的特有方法
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "test");
        treeMap.put(2, "test");
        treeMap.put(4, "test");
        treeMap.put(5, "test");

        // 查询所有key中，3的下确界（即第一个小于等于3的数）
        out.println(treeMap.floorKey(3));
        // 查询所有key中，3的上确界（即第一个大于等于3的数）
        out.println(treeMap.ceilingKey(3));

        out.flush();
        out.close();
        reader.close();
    }
}
