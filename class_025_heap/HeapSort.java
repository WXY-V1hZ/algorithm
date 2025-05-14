import java.io.*;
public class HeapSort {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static StreamTokenizer in = new StreamTokenizer(reader);
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        in.nextToken();
        int n = (int) in.nval;
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        heapSort(arr);

        printArr(arr);

        out.flush();
        out.close();
        reader.close();
    }

    public static void heapSort(int[] arr) {
        // 从顶到底建堆复杂度为 O(nlogn)，而从底到顶建堆复杂度为 O(n)
        // for (int i = 0; i < arr.length; ++i) {
        //     heapUp(arr, i);
        // }
        for (int i = arr.length - 1; i >= 0; --i) {
            heapDown(arr, i, arr.length);
        }
        int size = arr.length;
        while(size > 1) {
            swap(arr, 0, --size);
            heapDown(arr, 0, size);
        }
    }

    /**
     * 对于一个堆，向上调整位置i的数
     */
    // public static void heapUp(int[] heap, int i) {
    //     while(heap[i] > heap[father(i)]) {
    //         swap(heap, i, father(i));
    //         i = father(i);
    //     }
    // }

    /**
     * 对于一个堆，向下调整位置i的数
     */
    public static void heapDown(int[] heap, int i, int size) {
        int maxChild;
        int maxChildIndex;
        while(true) {
            if (lChild(i) >= size) {
                break;
            }
            maxChild = heap[lChild(i)];
            maxChildIndex = lChild(i);
            if (rChild(i) < size && heap[lChild(i)] < heap[rChild(i)]) {
                maxChild = heap[rChild(i)];
                maxChildIndex = rChild(i);
            }
            if (heap[i] >= maxChild) {
                break;
            }
            swap(heap, i, maxChildIndex);
            i = maxChildIndex;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int lChild(int i) {
        return (i << 1) + 1;
    }

    public static int rChild(int i) {
        return (i << 1) + 2;
    }

    public static int father(int i) {
        return i == 0 ? 0 : (i - 1) >> 1;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            out.print(arr[i] + " ");
        }
        out.println();
    }

}