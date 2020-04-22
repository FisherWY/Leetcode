package solution_ez;

/**
 * @Author: Fisher
 * @Date: 2020/4/22 21:32
 */

import java.util.Arrays;

/**
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。
 * （我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。 
 *
 * 示例 1：
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 *
 * 示例 2：
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 *
 * 示例 3：
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *  
 * 提示：
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int pos = 0;    // 记录最大的负数，也有可能没有
        while (pos < A.length && K > 0) {
            if (A[pos] < 0) {
                A[pos] = -A[pos];
                K--;
                pos++;
            } else {
                if (pos > 0 && A[pos] > A[pos - 1]) {
                    pos--;
                }
                break;
            }
        }
        if ((K & 1) == 1) {
            A[pos] = -A[pos];
        }
        int sum = 0;
        for (int x : A) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {-8, 3, -5, -3, -5, -2};
        int K = 6;
        solution1005 s = new solution1005();
        System.out.println(s.largestSumAfterKNegations(A, K));
    }
}
