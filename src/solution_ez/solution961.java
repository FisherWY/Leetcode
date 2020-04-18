package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/18 21:51
 **/

import java.util.Random;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 *
 * 示例 1：
 * 输入：[1,2,3,3]
 * 输出：3
 *
 * 示例 2：
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 *
 * 示例 3：
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 提示：
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution961 {

    public int repeatedNTimes(int[] A) {
        Random random = new Random(System.currentTimeMillis());
        int x = random.nextInt(A.length), y = random.nextInt(A.length);
        while (x == y || A[x] != A[y]) {
            x = random.nextInt(A.length);
            y = random.nextInt(A.length);
        }
        System.out.println("x:" + x + " y:" + y);
        return A[x];
    }

    public static void main(String[] args) {
        solution961 s = new solution961();
        int[] A = {5,1,5,2,5,3,5,4};
        System.out.println(s.repeatedNTimes(A));
    }
}
