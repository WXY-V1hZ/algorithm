import java.io.*;

public class Template {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];

    public static void main(String[] args) throws IOException {
        in.nextToken();
        int n = (int) in.nval;

        for (int i = 0; i < n; ++i) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }

        printArray(arr, n);

        out.flush();
        out.close();
        reader.close();
    }

    public static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; ++i) {
            out.print(arr[i] + " ");
        }
        out.println();
    }
}
