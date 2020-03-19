package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/19 21:30
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 *
 * 示例 1:
 * 输入: [1,3,2,2,5,2,3,7]
 * 输出: 5
 *
 * 原因: 最长的和谐数组是：[3,2,2,2,3].
 * 说明: 输入的数组长度最大不超过20,000.
 */
public class solution594 {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = 0;
        for (int x : map.keySet()) {
            int tmp = map.get(x) + map.getOrDefault(x + 1, Integer.MIN_VALUE);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        solution594 s = new solution594();
        System.out.println(s.findLHS(nums));
    }
}
