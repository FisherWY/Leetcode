package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/14 17:18
 **/

import java.util.Arrays;

/**
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，
 * 数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 *
 * 示例 2：
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * 提示：
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1300 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        // 二分查找
        int left = 0, right = arr[arr.length - 1], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int index = Arrays.binarySearch(arr, mid);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (arr.length - index) * mid;
            if (cur <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int sum1 = sum(arr, ans);
        int sum2 = sum(arr, ans + 1);
        return Math.abs(sum1 - target) <= Math.abs(sum2 - target) ? ans : ans + 1;
    }

    private int sum(int[] arr, int x) {
        int res = 0;
        for (int num : arr) {
            res += Math.min(num, x);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4,9,3};
        int target = 10;
        solution1300 s = new solution1300();
        System.out.println(s.findBestValue(arr, target));
    }
}
