package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/28 21:38
 **/

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 * 提示：
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution704 {

    public int search(int[] nums, int target) {
        return fun(nums, target, 0, nums.length - 1);
    }

    private int fun(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return fun(nums, target, mid + 1, right);
        } else {
            return fun(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        solution704 s = new solution704();
        System.out.println(s.search(nums, target));
    }
}
