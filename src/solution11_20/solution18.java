package solution11_20;

/**
 * @Author Fisher
 * @Date 2019/7/25 16:44
 **/

import java.util.*;

/**
 * Question18：四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 使用set去重
        Set<List<Integer>> set = new HashSet<>();
        // 如果数组长度小于4，直接返回空值
        if (nums.length < 4) {
            return new ArrayList<>(set);
        }
        // 对数组进行排序
        Arrays.sort(nums);

        for (int x : nums) {
            System.out.print(x + " ");
        }
        System.out.println();
        // 双重循环确定中间两个数
        for (int i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                // 左右指针，指向i的左右两边
                int left = 0, right = nums.length - 1;
                while (left < right) {
                    if (left==i || left==j) {
                        left++;
                        continue;
                    }
                    if (right==i || right==j) {
                        right--;
                        continue;
                    }
                    System.out.println("left: " + left + " right: " + right + " i: " + i + " j: " + j);
                    int sum = nums[left] + nums[i] + nums[j] + nums[right];
                    if (sum == target) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[left]);
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[right]);
                        Collections.sort(ans);
                        set.add(ans);
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        solution18 s18 = new solution18();
        int[] nums = {0,0,0,0};
        int target = 1;
        List<List<Integer>> res = s18.fourSum(nums, target);
        for (List<Integer> x : res) {
            for (Integer y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
