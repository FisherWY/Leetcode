package solution_mid;

/**
 * Question1004：最大连续1的个数-3
 */
public class solution1004 {

    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0, right = 0;
        int lsum = 0, rsum = 0;
        for (right = 0; right < A.length; right++) {
            rsum += 1 - A[right];
            while(lsum + K < rsum) {
                lsum += 1 - A[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    // 时间超限
    private int max;
    private int fun(int[] A, int k, int cur, int pos) {
        max = cur > max ? cur : max;
        if (pos == A.length - 1) {
            return cur;
        }
        if (A[pos] == 0) {
            if (k != 0) {
                return Math.max(fun(A, k - 1, cur + 1, pos + 1), fun(A, k, 0, pos + 1));
            } else {
                return fun(A, k, 0, pos + 1);
            }
        } else {
            return fun(A, k, cur + 1, pos + 1);
        }
    }
}
