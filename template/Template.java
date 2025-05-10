import java.io.*;

public class Template {
    public static int MAXN = (int) 1e5;
    public static int[] a = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            out.println(in.nval);
            out.println("a b c");
        }

        out.flush();
        out.close();
        reader.close();
    }
}
