import java.io.*;

public class RandomQuickSort {
    public static int MAXN = (int) 1e5;
    public static int[] a = new int[MAXN];
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken();
        int n = (int) in.nval;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        randomQuickSort(0, n - 1);
        for (int i = 0; i < n; ++i) {
            out.print(a[i] + " ");
        }
        out.println("");

        out.flush();
        out.close();
        reader.close();
    }

    public static void randomQuickSort(int l, int r) {
        if (l >= r) {
            return ;
        }
        int x = a[l + (int) (Math.random() * (r - l + 1))];

        // 必须先用临时变量记住，因为下面递归后两个全局变量会更新
        int left = lp - 1, right = rp + 1;
        
        partition(l, r, x);
        randomQuickSort(l, left);
        randomQuickSort(right, r);
    }

    /**
     * 将指定区域的数根据x进行划分，左侧<=x，右侧>x，所有x在中间
     */
    public static int lp, rp;
    public static void partition(int l, int r, int x) {
        lp = l;
        rp = r;
        int i = l;
        while(i <= rp) {
            if (a[i] < x) {
                swap(lp++, i++);
            } else if (a[i] == x) {
                ++i;
            } else if (a[i] > x) {
                swap(rp--, i);
            }
        }
    }

    /**
     * 交换a数组中i和j处的数
     */
    public static void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}