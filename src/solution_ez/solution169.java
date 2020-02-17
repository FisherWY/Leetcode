package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/17 22:34
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * Boyer-Moore投票算法：用前面积累的众数去抵消掉非众数，最后剩下的就是解
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution169 {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.get(x) == null) {
                map.put(x, 1);
            } else {
                map.put(x, map.get(x) + 1);
            }
        }
        for (Integer x : map.keySet()) {
            if (map.get(x) > nums.length / 2) {
                return x;
            }
        }
        return 0;
    }

    private int BoyerMoore(int[] nums) {
        int count = 0;
        int result = 0;

        for (int x : nums) {
            if (count == 0) {
                result = x;
            }
            count += (x == result ? 1 : -1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        solution169 s = new solution169();
        System.out.println(s.majorityElement(nums));
        System.out.println(s.BoyerMoore(nums));
    }
}
