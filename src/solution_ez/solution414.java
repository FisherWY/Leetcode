package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/4 22:00
 **/

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1。
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution414 {

    private int fun(int[] nums) {
        Integer thirdMax = null;
        Integer secondMax = null;
        Integer max = null;
        for (Integer number : nums) {
            if (number.equals(thirdMax) || number.equals(secondMax) || number.equals(max)) {
                continue;
            }
            if (thirdMax == null || number > thirdMax) {
                max = secondMax;
                secondMax = thirdMax;
                thirdMax = number;
            } else if (secondMax == null || number > secondMax) {
                max = secondMax;
                secondMax = number;
            } else if (max == null || number > max) {
                max = number;
            }
        }
        if (max == null) {
            return thirdMax;
        }
        return max;
    }

    public int thirdMax(int[] nums) {
        int small = Integer.MIN_VALUE, mid = Integer.MIN_VALUE, big = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x > big) {
                small = mid;
                mid = big;
                big = x;
            } else if (x > mid && x != big) {
                small = mid;
                mid = x;
            } else if (x > small && x != mid && x != big) {
                small = x;
            }
        }
        return (small == Integer.MIN_VALUE ? big : small);
    }

    public static void main(String[] args) {
        int[] array = {2,2,3,1};
        solution414 s = new solution414();
        System.out.println(s.fun(array));
    }
}
