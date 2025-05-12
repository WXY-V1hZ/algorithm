import java.io.*;

public class RandomSelect {
    public static int MAXN = (int) 1e5;
    public static int[] a = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        

        out.flush();
        out.close();
        reader.close();
    }

    public static int findKthLargest(int[] nums, int k) {
        return randomSelect(num, num.length - k);
    }

    /**
     * 如果给arr排序，在位置i的数字是什么
     */
    public static int randomSelect(int[] arr, int i) {
        for (int l = 0, r = arr.length - 1; l <= r;) {
            int x = arr[l + (int) (Math.random() * (r - l + 1))];
            partition(arr, l, r, x);
            if (lp <= i && i <= rp) {
                return arr[i];
            }
            if (i < lp) {
                r = lp - 1;
            } else if (i > rp) {
                l = rp + 1;
            }
        }
        return arr[i];
    }

    int lp, rp;
    public static void partition(int[] arr, int l, int r, int x) {
        lp = l;
        rp = r;
        int i = l;
        while(i <= rp) {
            if (arr[i] < x) {
                swap(arr, lp++, i++);
            } else if (arr[i] == x) {
                ++i;
            } else {
                swap(arr, rp--, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
