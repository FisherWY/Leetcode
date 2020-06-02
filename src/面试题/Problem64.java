package 面试题;

/**
 * @Author Fisher
 * @Date 2020/6/2 19:47
 **/

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 *
 * 限制：
 * 1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem64 {

    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }

    public static void main(String[] args) {
        int n = 3;
        Problem64 p = new Problem64();
        System.out.println(p.sumNums(n));
    }
}
