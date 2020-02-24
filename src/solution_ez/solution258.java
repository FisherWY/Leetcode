package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/24 21:23
 **/

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution258 {

    public int addDigits(int num) {
        if (num % 9 == 0 && num != 0) {
            return 9;
        } else {
            return num % 9;
        }
    }

    public static void main(String[] args) {
        solution258 s = new solution258();
        System.out.println(s.addDigits(38));
    }
}
