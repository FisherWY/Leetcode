package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/5/15 21:02
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 *
 * 说明 :
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = 0;
            for (int j = i; j < nums.length; j++) {
                tmp += nums[j];
                if (tmp == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int fun(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int x : nums) {
            pre += x;
            count += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        solution560 s = new solution560();
        System.out.println(s.subarraySum(nums, k));
        System.out.println(s.fun(nums, k));
    }
}
