package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/10 22:12
 **/

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 *
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, pos = 0, count = 0, len = nums.length;
        while (pos < len) {
            if (nums[pos] == 1) {
                count++;
            } else {
                max = (count > max ? count : max);
                count = 0;
            }
            pos++;
        }
        max = (count > max ? count : max);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        solution485 s = new solution485();
        System.out.println(s.findMaxConsecutiveOnes(nums));
    }
}
