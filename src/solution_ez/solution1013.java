package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/23 17:26
 **/

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 * 示例 1：
 * 输入：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution1013 {

    public boolean canThreePartsEqualSum(int[] A) {
        // 数组总和、左边划分标签、右边划分标签
        int sum = 0, i = 0, j = 0, current = 0, target = 0;
        for (int x : A) {
            sum += x;
        }
        if (sum % 3 != 0) {
            return false;
        }
        target = sum / 3;
        while (i < A.length) {
            current += A[i];
            if (current == target) {
                break;
            }
            i++;
        }
        if (current != target) {
            return false;
        }
        j = i + 1;
        while (j + 1 < A.length) {  // 满足最后一个数组非空
            current += A[j];
            if (current == target * 2) {
                return true;
            }
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {0,2,1,-6,6,7,9,-1,2,0,1};
        solution1013 s = new solution1013();
        System.out.println(s.canThreePartsEqualSum(A));
    }
}
