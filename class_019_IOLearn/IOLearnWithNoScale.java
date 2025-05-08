package class_019_IOLearn;

import java.io.*;

/**
 * 每行的数据规模未知的情况下的写法
 */
public class IOLearnWithNoScale {
    static int MAXN = (int) 1e10;
    static int[][] mat = new int[MAXN][MAXN];
    static int n;
    static String line;
    static String[] parts;
    static int sum;

    public static void main(String[] args) throws IOException {
        // BufferedReader会把文件内的一大块读入内存，后续需要使用就可以从内存中拿，更高效
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 输出
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while((line = reader.readLine()) != null) { // 文件没有结束就继续
            parts = line.split(" ");
            sum = 0;
            for (String strNum : parts) {
                sum += Integer.parseInt(strNum);
            }
            out.println(sum);
        }

        out.flush();
    }
}
