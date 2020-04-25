package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/25 23:07
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution46 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList<>(nums.length), nums, new int[nums.length]);
        return res;
    }

    private void helper(List<Integer> list, int[] nums, int[] visited) {
        if (list.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(list);
            res.add(copy);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                list.add(nums[i]);
                helper(list, nums, visited);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        solution46 s = new solution46();
        for (List<Integer> list : s.permute(nums)) {
            for (Integer x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
