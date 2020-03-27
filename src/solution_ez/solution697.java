package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/27 20:55
 **/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if (left.get(nums[i]) == null) {
                left.put(nums[i], i);
                right.put(nums[i], i);
            } else {
                right.put(nums[i], i);
            }
        }

        int degree = Collections.max(count.values());
        int minLen = Integer.MAX_VALUE;
        for (int x : count.keySet()) {
            if (degree == count.get(x)) {
                int d = right.get(x) - left.get(x) + 1;
                minLen = (d < minLen ? d : minLen);
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        solution697 s = new solution697();
        System.out.println(s.findShortestSubArray(nums));
    }
}
