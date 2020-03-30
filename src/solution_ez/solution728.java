package solution_ez;

/**
 * @Author Fisher
 * @Date 2020/3/30 21:42
 **/

import java.util.LinkedList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 *
 * 示例 1：
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 *
 * 注意：
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (fun(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean fun(int x) {
        int tail = x;
        while (tail != 0) {
            if (tail % 10 == 0 || x % (tail % 10) != 0) {
                return false;
            }
            tail /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 1, right = 22;
        solution728 s = new solution728();
        List<Integer> res = s.selfDividingNumbers(left, right);
        for (Integer x : res) {
            System.out.print(x + " ");
        }
    }
}
