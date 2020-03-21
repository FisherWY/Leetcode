package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/21 21:39
 **/

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution633 {

    public boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); i++) {
            double res = Math.sqrt(c - i * i);
            if (Math.floor(res) == res) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        solution633 s = new solution633();
        if (s.judgeSquareSum(0)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
