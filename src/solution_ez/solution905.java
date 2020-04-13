package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/4/13 22:06
 **/

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 提示：
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution905 {

    public int[] sortArrayByParity(int[] A) {
        int worker = 0;
        while (worker < A.length) {
            int pointer = worker + 1;
            if (A[worker] % 2 != 0) {
                while (pointer < A.length && A[pointer] % 2 != 0) {
                    pointer++;
                }
                if (pointer < A.length) {
                    int tmp = A[worker];
                    A[worker] = A[pointer];
                    A[pointer] = tmp;
                } else {
                    return A;
                }
            }
            worker++;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4};
        solution905 s = new solution905();
        int[] res = s.sortArrayByParity(A);
        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}
