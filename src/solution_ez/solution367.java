package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/29 22:16
 **/

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 * 输入：16
 * 输出：True
 *
 * 示例 2：
 * 输入：14
 * 输出：False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution367 {

    public boolean isPerfectSquare(int num) {
        // return fun(num, 1, num);
        // 牛顿迭代法
        if (num < 2) {
            return true;
        }

        long x = num / 2;
        while ((x * x) > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    private boolean fun(int num, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        int res = mid * mid;
        if (res == num) {
            return true;
        } else if (res > num) {
            return fun(num, left, mid - 1);
        } else {
            return fun(num, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        solution367 s = new solution367();
        if (s.isPerfectSquare(14)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
