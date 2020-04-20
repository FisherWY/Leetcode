package solution_ez;

/**
 * @Author: Fisher
 * @Date: 2020/4/20 22:53
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 * 提示：
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        int[] B = intToArray(K);
        int pos1 = A.length - 1, pos2 = B.length - 1;
        boolean carry = false;
        while (pos1 >= 0 && pos2 >= 0) {
            int res = A[pos1] + B[pos2];
            if (carry) {
                res += 1;
            }
            list.add(0, res % 10);
            carry = (res >= 10);
            pos1--;
            pos2--;
        }
        while (pos1 >= 0) {
            int res = A[pos1];
            if (carry) {
                res += 1;
            }
            list.add(0, res % 10);
            carry = (res >= 10);
            pos1--;
        }
        while (pos2 >= 0) {
            int res = B[pos2];
            if (carry) {
                res += 1;
            }
            list.add(0, res % 10);
            carry = (res >= 10);
            pos2--;
        }
        if (carry) {
            list.add(0, 1);
        }
        return list;
    }

    private int[] intToArray(int x) {
        List<Integer> list = new LinkedList<>();
        while (x != 0) {
            list.add(0, x % 10);
            x /= 10;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0};
        int K = 23;
        solution989 s = new solution989();
        List<Integer> res = s.addToArrayForm(A, K);
        for (Integer x : res) {
            System.out.print(x + " ");
        }
    }

}
