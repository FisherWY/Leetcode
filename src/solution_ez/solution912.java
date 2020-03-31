package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/31 22:17
 **/

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 * 提示：
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution912 {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            // base为左侧挖出的坑
            int i = left, j = right, base = nums[left];
            // 以base为基准排序，左侧都小于base，右侧都大于base
            while (i < j) {
                // 从右向左找第一个小于base的数
                while (i < j && nums[j] >= base) {
                    j--;
                }
                // 左侧填坑
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                // 从左向右找第一个大于base的数
                while (i < j && nums[i] < base) {
                    i++;
                }
                // 右侧填坑
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            // 回填base
            nums[i] = base;
            // 分治法
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,1,2,0,0};
        solution912 s = new solution912();
        s.sortArray(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
