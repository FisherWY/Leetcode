package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/9 21:35
 **/

/**
 * 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。 
 * 如果没有两个连续的 1，返回 0 。
 *
 * 示例 1：
 * 输入：22
 * 输出：2
 * 解释：
 * 22 的二进制是 0b10110 。
 * 在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
 * 第一对连续的 1 中，两个 1 之间的距离为 2 。
 * 第二对连续的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 *
 * 示例 2：
 * 输入：5
 * 输出：2
 * 解释：
 * 5 的二进制是 0b101 。
 *
 * 示例 3：
 * 输入：6
 * 输出：1
 * 解释：
 * 6 的二进制是 0b110 。
 *
 * 示例 4：
 * 输入：8
 * 输出：0
 * 解释：
 * 8 的二进制是 0b1000 。
 * 在 8 的二进制表示中没有连续的 1，所以返回 0 。
 *
 * 提示：
 * 1 <= N <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-gap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution868 {

    public int binaryGap(int N) {
        int last = -1, distance = 0;
        for (int i = 0; i < 32; i++) {
            if ((N & 1) == 1) {
                if (last != -1) {
                    distance = Math.max(distance, i - last);
                }
                last = i;
            }
            N >>= 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        int N = 8;
        solution868 s = new solution868();
        System.out.println(s.binaryGap(N));
    }
}
