package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/15 22:13
 **/

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 最简单的HashMap人人都能想出来，这里就不写了
 * 看了下答案，最简单的方法是使用异或。
 * a ^ 0 = a
 * a ^ a = 0
 * 又因为异或满足交换律，因此将数组中的所有元素进行异或运算，结果就是只出现了一次的那个元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        solution136 s = new solution136();
        System.out.println(s.singleNumber(nums));
    }
}
