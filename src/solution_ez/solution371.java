package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/1 21:02
 **/

/**
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 *
 * 示例 1:
 * 输入: a = 1, b = 2
 * 输出: 3
 *
 * 示例 2:
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位
            int tmp = (a & b) << 1;
            // 同位加法
            a ^= b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        solution371 s = new solution371();
        System.out.println(s.getSum(-2, 3));
    }
}
