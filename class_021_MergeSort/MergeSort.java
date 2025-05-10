package class_021_MergeSort;

import java.io.*;

public class MergeSort {
    static int MAXN = (int) 1e5;
    static int N, lp, rp, len;
    static int[] a = new int[MAXN];
    static int[] temp = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        in.nextToken();
        N = (int) in.nval;

        for (int i = 0; i < N; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

//        mergeSort(0, N - 1);
        mergeSortNoRecursion();

        for (int i = 0; i < N; ++i) {
            out.print(a[i]);
            out.print(" ");
        }
        out.println("");

        out.flush();
        out.close();
        reader.close();
    }

    /*
     * T(n) = 2 * T(n / 2) + O(n)
     * a = 2, b = 2, c = 1
     * 时间复杂度为 O(n * logn)
     * 空间复杂度为 O(n)
     */
    public static void mergeSort(int l, int r) {
        if (l == r) {
            return ;
        }

        int mid = (l + r) / 2;
        mergeSort(l, mid);
        mergeSort(mid + 1, r);

        merge(l, mid, r);
    }

    // O(logn)
    public static void mergeSortNoRecursion() {
        int step = 1, l, r, mid;
        while(step < N) {
            l = 0;
            while(l < N) {
                mid = l + step - 1;
                if (mid + 1 >= N) {
                    break;
                }
                r = Math.min(l + (step << 1) - 1, N - 1);
                merge(l, mid, r);
                l = r + 1;
            }
            step <<= 1;
        }
    }

    // O(n)
    public static void merge(int l, int mid, int r) {
        int lp = l, rp = mid + 1, i = l;
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
    }
}
