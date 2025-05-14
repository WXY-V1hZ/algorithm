import java.io.*;
import java.util.*;

public class HashSetLearn {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];

    public static void main(String[] args) throws IOException {
        
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(Integer.valueOf(1));
        
        out.println(hashSet.contains(1));

        out.flush();
        out.close();
        reader.close();
    }
}