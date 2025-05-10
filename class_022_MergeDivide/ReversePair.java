import java.io.*;
import java.util.*;

/**
 * https://leetcode.com/problems/reverse-pairs/description/
 */
public class ReversePair {
    public static int MAXN = (int) 5e4;
    public static int[] temp = new int[MAXN];

    public static List<Integer> a = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            a.add((int) in.nval);
        }

        out.println(reversePairs(a.stream()
                                .mapToInt(Integer::intValue)
                                .toArray()));

        out.flush();
        out.close();
        reader.close();
    }

    public static int reversePairs(int[] nums) {
        return solve(nums, 0, nums.length - 1);
    }

    public static int solve(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        return solve(nums, l, mid) + solve(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    public static int merge(int[] nums, int l, int mid, int r) {
        int lp, rp, i, ans, sum;
        // 统计跨左右的答案
        lp = mid;
        rp = r;
        sum = 0;
        ans = 0;
        while(lp >= l) {
            while(rp >= mid + 1 && (long) nums[lp] > (long) nums[rp] * 2) {
                sum++;
                rp--;
            }
            ans += sum;
            lp--;
        }

        // 归并排序
        lp = l;
        rp = mid + 1;
        i = l;
        while(lp <= mid && rp <= r) {
            temp[i++] = nums[lp] >= nums[rp] ? nums[lp++] : nums[rp++];
        }
        while(lp <= mid) {
            temp[i++] = nums[lp++];
        }
        while(rp <= r) {
            temp[i++] = nums[rp++];
        }
        for (i = l; i <= r; ++i) {
            nums[i] = temp[i];
        }

        return ans;
    }
}