package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/6/16 18:34
 **/

/**
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。
 * 如果数组中不存在满足题意的整数，则返回 0 。
 *
 * 示例：
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 *
 * 提示：
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/four-divisors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1390 {

    private int[] arr = new int[4];

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int x : nums) {
            if (fun(x)) {
                for (int num : arr) {
                    res += num;
                }
            }
        }
        return res;
    }

    private boolean fun(int x) {
        int pos = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                if (i * i == x && pos + 1 <= 4) {
                    arr[pos++] = i;
                } else if (pos + 2 <= 4){
                    arr[pos++] = i;
                    arr[pos++] = x / i;
                } else {
                    return false;
                }
            }
        }
        return pos == 4;
    }

    public static void main(String[] args) {
        int[] nums = {21,4,7};
        solution1390 s = new solution1390();
        System.out.println(s.sumFourDivisors(nums));
    }
}
