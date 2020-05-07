package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/7 22:11
 **/

/**
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 *
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 *
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 *
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 *  
 * 提示：
 * 1 <= n <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1304 {

    public int[] sumZero(int n) {
        int[] res = new int[n];
        int pos = 0, end = n / 2, ptr = 1;
        if (n % 2 == 1) {
            pos++;
        }
        while (ptr <= end) {
            res[pos] = ptr;
            pos++;
            res[pos] = -ptr;
            pos++;
            ptr++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        solution1304 s = new solution1304();
        for (int x : s.sumZero(n)) {
            System.out.print(x + " ");
        }
    }
}
