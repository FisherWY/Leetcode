package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/7/6 20:33
 **/

/**
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 *
 * 示例 1：
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 *
 * 示例 2：
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 *
 * 示例 4：
 * 输入：arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * 输出：1
 *
 * 示例 5：
 * 输入：arr = [4,4,4,4], k = 4, threshold = 1
 * 输出：1
 *
 * 提示：
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int cur = 0,left = 0, right = 0, count = 0;
        for (right = 0; right < k; right++) {
            cur += arr[right];
        }
        while (right < arr.length) {
            if (cur / k >= threshold) {
                count++;
            }
            cur -= arr[left++];
            cur += arr[right++];
        }
        return (cur / k >= threshold ? count + 1 : count);
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int k = 1, threshold = 0;
        solution1343 s = new solution1343();
        System.out.println(s.numOfSubarrays(arr, k, threshold));
    }
}
