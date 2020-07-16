package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/16 19:33
 **/

/**
 * 给你三个正整数 a、b 和 c。
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 *
 * 示例 1：
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 *
 * 示例 2：
 * 输入：a = 4, b = 2, c = 7
 * 输出：1
 *
 * 示例 3：
 * 输入：a = 1, b = 2, c = 3
 * 输出：0
 *
 * 提示：
 * 1 <= a <= 10^9
 * 1 <= b <= 10^9
 * 1 <= c <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1318 {

    public int minFlips(int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int tmpA = (a >> i) & 1;
            int tmpB = (b >> i) & 1;
            int tmpC = (c >> i) & 1;
            if (tmpC == 0) {
                count += tmpA + tmpB;
            } else {
                count += (tmpA + tmpB == 0 ? 1 : 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        solution1318 s = new solution1318();
        System.out.println(s.minFlips(1,2,3));
    }
}
