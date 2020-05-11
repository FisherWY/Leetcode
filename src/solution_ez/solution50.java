package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/11 21:28
 **/

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution50 {

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? fun(x, N) : 1.0 / fun(x, -N);
    }

    private double fun(double x, long n) {
        double res = 1.0;
        double base = x;
        while (n > 0) {
            if ((n % 2) == 1) {
                res *= base;
            }
            base *= base;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = -2;
        solution50 s = new solution50();
        System.out.println(s.myPow(x, n));
    }
}
