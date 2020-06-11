package solution1_10;

/**
 * @Author Fisher
 * @Date 2019/7/18 9:31
 **/

/**
 * Question9：回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution9 {

    public boolean isPalindrome(int x) {
        String origin = String.valueOf(x);
        String reverse = new StringBuilder(origin).reverse().toString();
        return origin.equals(reverse);
    }

    private boolean fun(int x) {
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = -121;
        solution9 s9 = new solution9();
        System.out.println(s9.isPalindrome(x));
        System.out.println(s9.fun(x));
    }

}
