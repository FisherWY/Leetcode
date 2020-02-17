package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/17 22:56
 **/

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 *
 * 理解：算式中出现了一次*10，尾部就会多一个零，10由1*10，2*5组成，都是5的倍数，因此只需要统计5的倍数出现的次数即可
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution172 {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) {
        solution172 s = new solution172();
        System.out.println(s.trailingZeroes(1000));
    }
}
