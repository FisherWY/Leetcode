package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/12 21:30
 **/

import java.util.Arrays;

/**
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 *
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * 示例 2：
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 *
 * 示例 3：
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *  
 * 提示：
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 1000 + i;
        }
        Arrays.sort(nums);
        boolean switcher = false;
        int pos = 0, offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] / 1000 > nums[i - 1] / 1000) {
                switcher = true;
                pos++;
            } else {
                offset++;
            }
            if (switcher) {
                pos += offset;
                res[nums[i] % 1000] = pos;
                offset = 0;
                switcher = false;
            } else {
                res[nums[i] % 1000] = pos;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7};
        solution1365 s = new solution1365();
        for (int x : s.smallerNumbersThanCurrent(nums)) {
            System.out.print(x + " ");
        }
    }
}
