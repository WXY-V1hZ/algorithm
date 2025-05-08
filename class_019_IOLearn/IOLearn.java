package class_019_IOLearn;

import java.io.*;

public class IOLearn {
    static int MAXN = (int) 1e5;
    static int[][] mat = new int[MAXN][MAXN];
    static int n;

    public static void main(String[] args) throws IOException {
        // BufferedReader会把文件内的一大块读入内存，后续需要使用就可以从内存中拿，更高效
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 从内存中一个一个读取数字
        StreamTokenizer in = new StreamTokenizer(reader);
        // 输出
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF) { // 文件没有结束就继续
            n = (int) in.nval;
            for (int i = 1; i <= n; ++i) {
                mat[i][i] = n;
            }
            out.println("test");
        }

        out.flush();

        out.close();
        reader.close();
    }
}
