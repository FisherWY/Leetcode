package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/27 20:14
 **/

/**
 * 给你一个整数 num，请你找出同时满足下面全部要求的两个整数：
 * 两数乘积等于  num + 1 或 num + 2
 * 以绝对差进行度量，两数大小最接近
 * 你可以按任意顺序返回这两个整数。
 *
 * 示例 1：
 * 输入：num = 8
 * 输出：[3,3]
 * 解释：对于 num + 1 = 9，最接近的两个因数是 3 & 3；对于 num + 2 = 10, 最接近的两个因数是 2 & 5，因此返回 3 & 3 。
 *
 * 示例 2：
 * 输入：num = 123
 * 输出：[5,25]
 *
 * 示例 3：
 * 输入：num = 999
 * 输出：[40,25]
 *
 * 提示：
 * 1 <= num <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/closest-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1362 {

    public int[] closestDivisors(int num) {
        int num1 = num + 1, num2 = num + 2;
        int x = (int) Math.sqrt(num2);
        int[] res = new int[2];
        for (int i = x; i >= 1; i--) {
            if (num1 % i == 0) {
                res[0] = i;
                res[1] = num1 / i;
                break;
            } else if (num2 % i == 0) {
                res[0] = i;
                res[1] = num2 / i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 8;
        solution1362 s = new solution1362();
        for (int x : s.closestDivisors(num)) {
            System.out.print(x + " ");
        }
    }
}
