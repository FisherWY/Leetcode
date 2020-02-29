package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/29 21:36
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] res = null;
        int pos = 0;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            set2.add(x);
        }
        if (set1.size() < set2.size()) {
            res = new int[set1.size()];
            for (Integer x : set1) {
                if (set2.contains(x)) {
                    res[pos++] = x;
                }
            }
        } else {
            res = new int[set2.size()];
            for (Integer x : set2) {
                if (set1.contains(x)) {
                    res[pos++] = x;
                }
            }
        }
        return Arrays.copyOf(res, pos);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        solution349 s = new solution349();
        int[] res = s.intersection(nums1, nums2);
        for (int x : res) {
            System.out.print(x + " -> ");
        }
    }
}
