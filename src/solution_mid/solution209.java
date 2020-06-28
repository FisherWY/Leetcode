package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/28 16:42
 **/

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 *
 * 进阶:
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, sum = 0, minLen = nums.length + 1;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return (minLen == nums.length + 1) ? 0 : minLen;
    }

    public static void main(String[] args) {
        int s = 15;
        int[] nums = {1,2,3,4,5};
        solution209 s209 = new solution209();
        System.out.println(s209.minSubArrayLen(s, nums));
    }
}
