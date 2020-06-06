package solution_hard;

/**
 * @Author Fisher
 * @Date 2020/6/6 18:36
 **/

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution128 {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int x : nums) {
            set.add(x);
        }
        Iterator<Integer> it = set.iterator();
        int res = 1, cur = 1, last = it.next();
        while (it.hasNext()) {
            int x = it.next();
            if (last + 1 == x) {
                cur++;
            } else {
                res = Math.max(res, cur);
                cur = 1;
            }
            last = x;
        }
        return Math.max(res, cur);
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        solution128 s = new solution128();
        System.out.println(s.longestConsecutive(nums));
    }
}
