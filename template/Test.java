import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        for (int i = 0; i < list.size(); ++i) {
            out.print(list.get(i) + " ");
        }
        out.println();

        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()) {
            out.println(iterator.next());
        }
        while(iterator.hasPrevious()) {
            out.println(iterator.previous());
        }

        list.removeIf(num -> num % 2 == 0);
        out.println(list);

        if (true) {
            out.println("test1");
        }
        if (false) {
            out.println("test0");
        }

        out.flush();
        out.close();
        reader.close();
    }
}