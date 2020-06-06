package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/6 21:24
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * 斐波那契数字定义为：
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 *
 * 示例 1：
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 *
 * 示例 2：
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 *
 * 示例 3：
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 *
 * 提示：
 * 1 <= k <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1414 {

    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        while (a + b <= k) {
            b = a + b;
            a = b - a;
        }
        int res = 0;
        while (k > 0) {
            if (k >= b) {
                res++;
                k -= b;
            }
            a = b - a;
            b = b - a;
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 645157245;
        solution1414 s = new solution1414();
        System.out.println(s.findMinFibonacciNumbers(k));
    }
}
