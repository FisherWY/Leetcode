package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/23 9:53
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question16：最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution16 {

    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, dist = 999;
        // 如果数组长度小于3，直接返回
        if (nums.length < 3) {
            return sum;
        }
        // 对数组进行排序
        Arrays.sort(nums);

        for (int i=1; i<nums.length-1; i++) {
            // 左右指针，指向i的左右两边
            int left = 0, right = nums.length - 1;
            while (left<i && right>i) {

                int tmp = nums[left] + nums[i] + nums[right];
                if (Math.abs(tmp - target) < dist) {
                    dist = Math.abs(tmp - target);
                    sum = tmp;
                }
                // 判断是哪边指针移动
                if (tmp - target < 0){
                    left++;
                } else if (tmp - target > 0) {
                    right--;
                } else {
                    // 找到答案
                    return sum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        solution16 s16 = new solution16();
        int[] nums = {0,1,2};
        int target = 3;
        System.out.println(s16.threeSumClosest(nums, target));
    }
}
