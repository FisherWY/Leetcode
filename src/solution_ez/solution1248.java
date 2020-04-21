package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/21 20:54
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odd = new ArrayList<>();
        odd.add(-1);
        int i = 1, res = 0;

        for (int pos = 0; pos <= nums.length; pos++) {
            // 到达边界或nums[pos]为奇数
            if (pos == nums.length || (nums[pos] & 1) == 1) {
                odd.add(pos);
            }

            if (odd.size() - i > k) {
                int left = odd.get(i) - odd.get(i - 1);
                int right = pos - odd.get(odd.size() - 2);
                res += left * right;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1};
        int k = 3;
        solution1248 s = new solution1248();
        System.out.println(s.numberOfSubarrays(nums, k));
    }
}
