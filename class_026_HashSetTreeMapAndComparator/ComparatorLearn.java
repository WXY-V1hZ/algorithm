import java.io.*;
import java.util.*;

public class Template {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];

    public static void main(String[] args) throws IOException {
        
        List<Test> list = new ArrayList<>();

        list.add(new Test(3, "C"));
        list.add(new Test(1, "A"));
        list.add(new Test(2, "B"));
        list.add(new Test(5, "E"));
        list.add(new Test(4, "D"));

        out.println(list);

        // list.sort(new TestComparator());
        list.sort((o1, o2) -> o2.sort - o1.sort);

        out.println(list);

        out.flush();
        out.close();
        reader.close();
    }

    public static class Test {
        int sort;
        String str;

        public Test(int sort, String str) {
            this.sort = sort;
            this.str = str;
        }

        public String toString() {
            return this.str;
        }
    }

    /**
     * 比较器默认返回负数表示o1优先级更高，返回正数表示o2优先级更高，返回0表示二者优先级一样
     */
    public static class TestComparator implements Comparator<Test> {
        @Override
        public int compare(Test o1, Test o2) {
            // sort越小优先级越高
            return o1.sort - o2.sort;
        }
    }
}
