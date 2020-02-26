package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/2/25 21:53
 **/

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution283 {

    public void moveZeroes(int[] nums) {
        int left = nums.length - 1, right = nums.length - 1;
        while (left >= 0) {
            if (nums[left] == 0) {
                for (int i = left; i < right; i++) {
                    int tmp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tmp;
                }
                right--;
            }
            left--;
        }
    }

    private void fun(int[] nums) {
        for (int last = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                int tmp = nums[cur];
                nums[cur] = nums[last];
                nums[last] = tmp;
                last++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        solution283 s = new solution283();
        s.fun(nums);
        for (int x : nums) {
            System.out.print(x + " -> ");
        }
    }
}
