package solution21_30;

/**
 * @Author Fisher
 * @Date 2019/8/4 10:12
 **/

/**
 * Question29：两数相除
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution29 {
    public int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int time = 0;
        int res = dividend;

        while (res <= divisor) {
            res = res - divisor;
            time++;
        }

        return flag ? time : -time;
    }

    private int fun(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // 全部记录为负数，统一符号，同时避免最大负数转为正数时会溢出的问题
        int positiveDividend = dividend > 0 ? 0 - dividend : dividend;
        int positiveDivisor = divisor > 0 ? 0 - divisor : divisor;
        // 记录位运算左移次数
        int leftTime = 0;
        int result = 0;
        // 记录最小整数右移一位的结果
        int maxRight1 = Integer.MIN_VALUE >> 1;
        if (dividend == 0 || positiveDividend - positiveDivisor > 0) return 0;
        while (positiveDividend - positiveDivisor < 0) {
            // 如果除数小于最小整数右移一位，说明不能再左移了，跳出循环
            if (positiveDivisor < maxRight1 || positiveDividend - (positiveDivisor << 1) > 0) break;
            positiveDivisor = positiveDivisor << 1;
            leftTime ++;
        }
        // 递归
        result = (1 << leftTime)
                + fun(positiveDividend - positiveDivisor, divisor > 0 ? 0 - divisor : divisor);
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            result = 0 - result;
        }
        return result;
    }

    public static void main(String[] args) {
        int dividend = 100;
        int divisor = 3;
        solution29 s29 = new solution29();
        System.out.println(s29.divide(dividend, divisor));
        System.out.println(s29.fun(dividend, divisor));
    }
}
