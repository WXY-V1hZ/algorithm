import java.io.*;

/**
 * https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
 * 
 * 归并分治：
 * 1. 整体答案 = 左部分答案 + 右部分答案 + 跨左右产生的答案
 * 2. 计算“跨左右产生的答案”时，若加上左右各自有序的设定，会获得计算的便利性
 */
public class SmallSum {
    public static int MAXN = (int) 1e5;
    public static int[] a = new int[MAXN];
    public static int[] temp = new int[MAXN];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        out.println(smallSum(0, n - 1));

        out.flush();
        out.close();
        reader.close();
    }

    public static long smallSum(int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        return smallSum(l, mid) + smallSum(mid + 1, r) + merge(l, mid, r);
    }

    // 左右两侧已经有序，返回跨左右的答案
    public static long merge(int l, int mid, int r) {
        // 计算跨左右的答案
        int lp = l, rp = mid + 1;
        long ans = 0, sum = 0;
        while(rp <= r) {
            while(lp <= mid && a[lp] <= a[rp]) {
                sum += a[lp++];
            }
            ans += sum;
            rp++;
        }
        
        // 合并左右两段，使其有序
        lp = l;
        rp = mid + 1;
        int i = l;
        while(lp <= mid && rp <= r) {
            temp[i++] = a[lp] <= a[rp] ? a[lp++] : a[rp++];
        }
        while(lp <= mid) {
            temp[i++] = a[lp++];
        }
        while(rp <= r) {
            temp[i++] = a[rp++];
        }
        for (i = l; i <= r; ++i) {
            a[i] = temp[i];
        }

        return ans;
    }
}