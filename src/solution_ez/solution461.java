package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/8 21:28
 **/

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution461 {

    public int hammingDistance(int x, int y) {
        int count = 0;
        int xor = x ^ y;
        // 布莱恩·克尼根算法
        while (xor != 0) {
            count++;
            xor &= xor - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        solution461 s = new solution461();
        System.out.println(s.hammingDistance(x, y));
    }
}
