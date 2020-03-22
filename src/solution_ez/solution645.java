package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/22 22:08
 **/

import java.util.Arrays;

/**
 * 集合 S 包含从1到 n 的整数。
 * 不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 *
 * 注意:
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution645 {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] times = new int[nums.length];
        for (int x : nums) {
            times[x - 1]++;
        }
        for (int i = 0; i < times.length; i++) {
            if (times[i] == 0) {
                res[1] = i + 1;
            }
            if (times[i] == 2) {
                res[0] = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,4,6,5};
        solution645 s = new solution645();
        int[] res = s.findErrorNums(nums);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
