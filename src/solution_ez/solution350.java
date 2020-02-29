package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/29 21:57
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[(nums1.length < nums2.length ? nums1.length : nums2.length)];
        int pos = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        for (int x : nums2) {
            if (map.containsKey(x)) {
                res[pos++] = x;
                int count = map.get(x) - 1;
                if (count <= 0) {
                    map.remove(x);
                } else {
                    map.put(x, count);
                }
            }
        }
        return Arrays.copyOf(res, pos);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        solution350 s = new solution350();
        int[] res = s.intersect(nums1, nums2);
        for (int x : res) {
            System.out.print(x + " -> ");
        }
    }
}
