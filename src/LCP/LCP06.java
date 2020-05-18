package LCP;

/**
 * @Author Fisher
 * @Date 2020/5/18 21:20
 **/

/**
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * 示例 1：
 * 输入：[4,2,1]
 * 输出：4
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 示例 2：
 * 输入：[2,3,10]
 * 输出：8
 *
 * 限制：
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/na-ying-bi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP06 {

    public int minCount(int[] coins) {
        int res = 0;
        for (int x : coins) {
            res += x / 2;
            res += (x & 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = {2,3,10};
        LCP06 lcp06 = new LCP06();
        System.out.println(lcp06.minCount(coins));
    }
}
