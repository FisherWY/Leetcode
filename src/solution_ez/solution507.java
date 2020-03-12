package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/12 22:04
 **/

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 给定一个 整数 n， 如果他是完美数，返回 True，否则返回 False
 *
 * 示例：
 * 输入: 28
 *
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 *
 * 提示：
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 *
 * 官方解析：欧几里得-欧拉定理告诉我们，每个偶完全数都可以写成 2^(p-1) * (2^p - 1)的形式，其中 p 为素数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution507 {

    private int fun(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }

    public boolean checkPerfectNumber(int num) {
        // 素数集合
        int[] primes = {2,3,5,7,13,17,19,31};
        for (int p : primes) {
            if (fun(p) == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 28;
        solution507 s = new solution507();
        System.out.println(s.checkPerfectNumber(num));
    }
}
