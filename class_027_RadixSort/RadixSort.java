import java.io.*;
import java.util.*;

public class Main {

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static int MAXN = (int) 1e5 + 5;
    public static int[] arr = new int[MAXN];
    public static int[] temp = new int[MAXN];
    public static int BASE = 17;
    public static int[] cnts = new int[BASE];

    public static void main(String[] args) throws IOException {
        
        in.nextToken();
        int n = (int) in.nval;
        int maxBits = 0;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            arr[i] = (int) in.nval;
            maxBits = Math.max(maxBits, getBits(arr[i]));
        }

        radixSort(arr, n, maxBits);

        for (int i = 0; i < n; ++i) {
            out.print(arr[i] + " ");
        }
        out.println();

        out.flush();
        out.close();
        reader.close();
    }

    public static void radixSort(int[] arr, int n, int bits) {
        int offset = 1;
        while(bits > 0) {
            Arrays.fill(cnts, 0); // 重置基数数组
            for (int i = 0; i < n; ++i) { // 根据当前位计数
                ++cnts[getBit(arr[i], offset)];
            }
            for (int i = 1; i < BASE; ++i) { // 构建基数数组前缀和
                cnts[i] += cnts[i - 1];
            }
            for (int i = n - 1; i >= 0; --i) { // 根据前缀和将每个数放到辅助数组
                temp[--cnts[getBit(arr[i], offset)]] = arr[i];
            }
            for (int i = 0; i < n; ++i) { // 更新数组
                arr[i] = temp[i];
            }
            offset *= BASE;
            --bits;
        }
    }

    public static int getBit(int x, int offset) {
        return (x / offset) % BASE;
    }

    public static int getBits(int x) {
        int ans = 0;
        while(x > 0) {
            ++ans;
            x /= 10;
        }
        return ans;
    }
}