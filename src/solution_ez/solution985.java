package solution_ez;

/**
 * @Author: Fisher
 * @Date: 2020/4/20 22:17
 */

/**
 * 给出一个整数数组 A 和一个查询数组 queries。
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 *
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * 提示：
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] res = new int[queries.length];
        // 初始数组A偶数和
        for (int x : A) {
            if (x % 2 == 0) {
                sum += x;
            }
        }
        // 每一次查询
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            // 加上去是偶数
            if ((A[query[1]] + query[0]) % 2 == 0) {
                // 本来就是偶数
                if (A[query[1]] % 2 == 0) {
                    sum += query[0];
                } else {    // 新加的偶数
                    sum += A[query[1]] + query[0];
                }
            } else {    // 加上去是奇数
                // 本来是偶数
                if (A[query[1]] % 2 == 0) {
                    sum -= A[query[1]];
                }
            }
            res[i] = sum;
            A[query[1]] += query[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3,2};
        int[][] queries = {
                {4,0},
                {3,0},
        };
        solution985 s = new solution985();
        int[] res = s.sumEvenAfterQueries(A, queries);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
