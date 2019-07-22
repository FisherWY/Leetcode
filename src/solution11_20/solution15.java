package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/22 10:06
 **/

import java.util.*;

/**
 * Question15：三数之和
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 使用set去重
        Set<List<Integer>> set = new HashSet<>();
        // 如果数组长度小于3，直接返回空值
        if (nums.length < 3) {
            return new ArrayList<>(set);
        }
        // 对数组进行排序
        Arrays.sort(nums);

        for (int i=1; i<nums.length-1; i++) {
            // 左右指针，指向i的左右两边
            int left = 0, right = nums.length - 1;
            while (left<i && right>i) {
                if (nums[left] + nums[i] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[i]);
                    list.add(nums[right]);
                    set.add(list);
                    // 以i为中心的结果可能不止一个，因此需要继续寻找
                    left++;
                    right--;
                } else if (nums[left] + nums[i] + nums[right] < 0){
                    left++;
                } else if (nums[left] + nums[i] + nums[right] > 0) {
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        solution15 s15 = new solution15();
        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> res = s15.threeSum(nums);
        for (List<Integer> x : res) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
