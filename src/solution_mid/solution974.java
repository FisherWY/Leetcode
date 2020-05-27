package solution_mid;

/**
 * @Author Fisher
 * @Date 2020/5/27 21:30
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 示例：
 * 输入：A = [4,5,0,-2,-3,1], K = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 K = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *
 * 提示：
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution974 {

    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int x : A) {
            sum += x;
            int remain = Math.floorMod(sum, K);
            int record = map.getOrDefault(remain, 0);
            res += record;
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {4,5,0,-2,-3,1};
        int K = 5;
        solution974 s = new solution974();
        System.out.println(s.subarraysDivByK(A, K));
    }
}
