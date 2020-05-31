package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/5/31 20:37
 **/

/**
 * 给你一个整数 num 。你可以对它进行如下步骤恰好 两次 ：
 * 选择一个数字 x (0 <= x <= 9).
 * 选择另一个数字 y (0 <= y <= 9) 。数字 y 可以等于 x 。
 * 将 num 中所有出现 x 的数位都用 y 替换。
 * 得到的新的整数 不能 有前导 0 ，得到的新整数也 不能 是 0 。
 * 令两次对 num 的操作得到的结果分别为 a 和 b 。
 * 请你返回 a 和 b 的 最大差值 。
 *
 * 示例 1：
 * 输入：num = 555
 * 输出：888
 * 解释：第一次选择 x = 5 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 5 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 999 和 b = 111 ，最大差值为 888
 *
 * 示例 2：
 * 输入：num = 9
 * 输出：8
 * 解释：第一次选择 x = 9 且 y = 9 ，并把得到的新数字保存在 a 中。
 * 第二次选择 x = 9 且 y = 1 ，并把得到的新数字保存在 b 中。
 * 现在，我们有 a = 9 和 b = 1 ，最大差值为 8
 *
 * 示例 3：
 * 输入：num = 123456
 * 输出：820000
 *
 * 示例 4：
 * 输入：num = 10000
 * 输出：80000
 *
 * 示例 5：
 * 输入：num = 9288
 * 输出：8700
 *
 * 提示：
 * 1 <= num <= 10^8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-difference-you-can-get-from-changing-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1432 {

    public int maxDiff(int num) {
        int max = 0, min = 0;
        int[] nums = new int[9];
        int start = nums.length;
        while (num != 0) {
            nums[--start] = num % 10;
            num /= 10;
        }
        // 寻找最大值
        int toMax = 0;
        boolean find = false;
        for (int i = start; i < nums.length; i++) {
            if (!find && nums[i] != 9) {
                toMax = nums[i];
                find = true;
            }
            if (nums[i] == toMax) {
                max = max * 10 + 9;
            } else {
                max = max * 10 + nums[i];
            }
        }
        // 寻找最小值
        int toMin = 0;
        if (nums[start] != 1) {
            toMin = nums[start];
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == toMin) {
                    min = min * 10 + 1;
                } else {
                    min = min * 10 + nums[i];
                }
            }
        } else {
            find = false;
            for (int i = start; i < nums.length; i++) {
                if (!find && nums[i] != 1 && nums[i] != 0) {
                    toMin = nums[i];
                    find = true;
                }
                if (nums[i] == toMin) {
                    min = min * 10;
                } else {
                    min = min * 10 + nums[i];
                }
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        int num = 9288;
        solution1432 s = new solution1432();
        System.out.println(s.maxDiff(num));
    }
}
