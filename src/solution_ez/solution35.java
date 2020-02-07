package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/7 10:50
 **/

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class solution35 {

    public int searchInsert(int[] nums, int target) {
        int pos = nums.length / 2;
        return find(nums, target, pos, 0, nums.length-1);
    }

    private int find(int[] nums, int target, int pos, int left, int right) {
        // 在数组中找不到target，返回的插入位置
        if (left > right) {
            return left;
        }
        if (nums[pos] == target) {
            return pos;
        } else if (nums[pos] < target) {
            // （关键）二分法中搜索范围的收敛
            // 错误的原因是直接使left=pos，导致了如left=2，pos=2，right=3时的死循环
            left = pos + 1;
        } else if (nums[pos] > target) {
            // 同上一种情况一样的道理
            right = pos - 1;
        }
        // 使用新的左右两侧范围计算的索引
        pos = (left + right) / 2;
        return find(nums, target, pos, left, right);
    }

    public static void main(String[] args) {
        solution35 s = new solution35();
        int nums[] = {1,3,5,6};
        int target = 0;
        int res = s.searchInsert(nums, target);
        System.out.println(res);
    }
}
